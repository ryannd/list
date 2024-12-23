package com.ryannd.list_api.controller;

import com.ryannd.list_api.domain.MediaRequest;
import com.ryannd.list_api.entity.Media;
import com.ryannd.list_api.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/media")
public class MediaController {
    @Autowired private MediaService mediaService;

    @GetMapping
    public Iterable<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    @PostMapping("/add")
    public Media addMediaToUser(@RequestBody MediaRequest request) {
        return mediaService.getMedia(request.getId(), request.getSource(), request.getType());
    }
}
