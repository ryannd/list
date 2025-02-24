package com.ryannd.list_api.controller;

import com.ryannd.list_api.entity.Media;
import com.ryannd.list_api.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/details")
public class DetailsController {
    @Autowired private MediaService mediaService;

    @GetMapping("/movie/{id}")
    public Media searchMovies(@PathVariable String id) {
        return mediaService.getMedia(id, "tmdb", "movie");
    }

    @GetMapping("/show/{id}")
    public Media searchShows(@PathVariable String id) {
        return mediaService.getMedia(id, "tmdb", "tv");
    }
}
