package com.ryannd.list_api.service;

import com.ryannd.list_api.config.WebConstants;
import com.ryannd.list_api.domain.TmdbMovie;
import com.ryannd.list_api.domain.TmdbShow;
import com.ryannd.list_api.entity.Media;
import com.ryannd.list_api.entity.Season;
import com.ryannd.list_api.repository.MediaRepository;
import com.ryannd.list_api.repository.SeasonRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {
    @Autowired private TmdbService tmdbService;
    private final MediaRepository mediaRepository;
    private final SeasonRepository seasonRepository;

    public MediaService(MediaRepository mediaRepository, SeasonRepository seasonRepository) {
        this.mediaRepository = mediaRepository;
        this.seasonRepository = seasonRepository;
    }

    public Iterable<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Optional<Media> getMedia(String id) {
        return mediaRepository.findById(id);
    }

    public Media getMedia(String id, String source, String type) {
        Optional<Media> media = mediaRepository.find(id, "tmdb", type);
        if (media.isPresent()) {
            return media.get();
        } else if (type.equals("tv")) {
            TmdbShow show = tmdbService.getShow(id);
            ArrayList<Season> seasons = new ArrayList<>();
            show.seasons()
                    .forEach(
                            season -> {
                                Season newSeason =
                                        new Season(
                                                season.name(),
                                                "tmdb",
                                                season.id(),
                                                season.season_number(),
                                                season.episode_count());
                                seasons.add(newSeason);
                                seasonRepository.save(newSeason);
                            });

            Media newShow =
                    new Media(
                            show.name(),
                            show.id(),
                            "tmdb",
                            show.overview(),
                            WebConstants.TMDB_IMG_BASE_PATH + show.poster_path(),
                            WebConstants.TMDB_IMG_BASE_PATH + show.backdrop_path(),
                            "tv",
                            seasons);
            mediaRepository.save(newShow);

            return newShow;
        } else {
            TmdbMovie movie = tmdbService.getMovie(id);
            Media newMovie =
                    new Media(
                            movie.title(),
                            movie.id(),
                            "tmdb",
                            movie.overview(),
                            WebConstants.TMDB_IMG_BASE_PATH + movie.poster_path(),
                            WebConstants.TMDB_IMG_BASE_PATH + movie.backdrop_path(),
                            "movie");
            mediaRepository.save(newMovie);
            return newMovie;
        }
    }
}
