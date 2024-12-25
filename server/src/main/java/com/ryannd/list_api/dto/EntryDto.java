package com.ryannd.list_api.dto;

import com.ryannd.list_api.domain.MediaRequest;

public class EntryDto {
    private String status;
    private Integer episodeProgress;
    private Integer seasonProgress;
    private Integer rating;
    private MediaRequest mediaRequest;

    public EntryDto() {}

    public EntryDto(
            String status,
            Integer episodeProgress,
            Integer seasonProgress,
            Integer rating,
            MediaRequest mediaRequest) {
        this.status = status;
        this.episodeProgress = episodeProgress;
        this.seasonProgress = seasonProgress;
        this.rating = rating;
        this.mediaRequest = mediaRequest;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEpisodeProgress() {
        return episodeProgress;
    }

    public void setEpisodeProgress(Integer episodeProgress) {
        this.episodeProgress = episodeProgress;
    }

    public Integer getSeasonProgress() {
        return seasonProgress;
    }

    public void setSeasonProgress(Integer seasonProgress) {
        this.seasonProgress = seasonProgress;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public MediaRequest getMediaRequest() {
        return mediaRequest;
    }

    public void setMediaRequest(MediaRequest mediaRequest) {
        this.mediaRequest = mediaRequest;
    }
}
