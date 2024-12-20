package com.ryannd.list_api.controller;

import com.ryannd.list_api.domain.TmdbMovie;
import com.ryannd.list_api.domain.TmdbShow;
import com.ryannd.list_api.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/details")
public class DetailsController {
    @Autowired private TmdbService tmdbService;

    @GetMapping("/movie/{id}")
    public TmdbMovie searchMovies(@PathVariable Long id) {
        return tmdbService.getMovie(id);
    }

    @GetMapping("/show/{id}")
    public TmdbShow searchShows(@PathVariable Long id) {
        return tmdbService.getShow(id);
    }
}
