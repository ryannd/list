package com.ryannd.list_api.controller;

import com.ryannd.list_api.domain.TmdbSearchResults;
import com.ryannd.list_api.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired private TmdbService tmdbService;

    @GetMapping("/movies")
    public TmdbSearchResults searchMovies(@RequestParam String query) {
        return tmdbService.searchMovies(query);
    }
}
