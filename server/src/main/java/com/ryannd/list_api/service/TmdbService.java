package com.ryannd.list_api.service;

import com.ryannd.list_api.domain.TmdbMovie;
import com.ryannd.list_api.domain.TmdbSearchResponse;
import com.ryannd.list_api.domain.TmdbSearchResult;
import com.ryannd.list_api.domain.TmdbShow;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

@Service
public class TmdbService {
    @Value("${tmdbKey}")
    private String apiKey;

    private final WebClient webClient;

    private WebClient.RequestHeadersUriSpec<?> getWithAuth() {
        return (RequestHeadersUriSpec<?>)
                webClient
                        .get()
                        .header("accept", "application/json")
                        .header("Authorization", "Bearer " + apiKey);
    }

    public TmdbService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.themoviedb.org/3").build();
    }

    public TmdbSearchResponse searchMovies(String query) {
        return getWithAuth()
                .uri(
                        uriBuilder ->
                                uriBuilder.path("/search/movie").queryParam("query", query).build())
                .retrieve()
                .bodyToMono(TmdbSearchResponse.class)
                .map(
                        response -> {
                            List<TmdbSearchResult> updated =
                                    response.results().stream()
                                            .map(
                                                    result ->
                                                            new TmdbSearchResult(
                                                                    result.backdrop_path(),
                                                                    result.id(),
                                                                    result.title(),
                                                                    result.overview(),
                                                                    result.poster_path(),
                                                                    "movie"))
                                            .toList();
                            return new TmdbSearchResponse(response.page(), updated);
                        })
                .block();
    }

    public TmdbSearchResponse searchShows(String query) {
        return getWithAuth()
                .uri(uriBuilder -> uriBuilder.path("/search/tv").queryParam("query", query).build())
                .retrieve()
                .bodyToMono(TmdbSearchResponse.class)
                .map(
                        response -> {
                            List<TmdbSearchResult> updated =
                                    response.results().stream()
                                            .map(
                                                    result ->
                                                            new TmdbSearchResult(
                                                                    result.backdrop_path(),
                                                                    result.id(),
                                                                    result.title(),
                                                                    result.overview(),
                                                                    result.poster_path(),
                                                                    "tv"))
                                            .toList();
                            return new TmdbSearchResponse(response.page(), updated);
                        })
                .block();
    }

    public TmdbSearchResponse searchAll(String query) {
        return getWithAuth()
                .uri(
                        uriBuilder ->
                                uriBuilder.path("/search/multi").queryParam("query", query).build())
                .retrieve()
                .bodyToMono(TmdbSearchResponse.class)
                .map(
                        response -> {
                            List<TmdbSearchResult> updated =
                                    response.results().stream()
                                            .filter(
                                                    result ->
                                                            result.media_type().equals("movie")
                                                                    || result.media_type()
                                                                            .equals("tv"))
                                            .toList();
                            return new TmdbSearchResponse(response.page(), updated);
                        })
                .block();
    }

    public TmdbShow getShow(Long id) {
        return getWithAuth()
                .uri(uriBuilder -> uriBuilder.path("/tv/" + id).build())
                .retrieve()
                .bodyToMono(TmdbShow.class)
                .block();
    }

    public TmdbMovie getMovie(Long id) {
        return getWithAuth()
                .uri(uriBuilder -> uriBuilder.path("/movie/" + id).build())
                .retrieve()
                .bodyToMono(TmdbMovie.class)
                .block();
    }
}
