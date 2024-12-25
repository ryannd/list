package com.ryannd.list_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "entries")
public class Entry {
    @Id @UuidGenerator private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id")
    private Media media;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer episodeProgress;
    private Integer seasonProgress;
    private Integer rating;

    public enum Status {
        PLANNING,
        WATCHING,
        COMPLETED
    }

    @SuppressWarnings("unused")
    private Entry() {}

    // show
    public Entry(
            Media media,
            Status status,
            Integer episodeProgress,
            Integer seasonProgress,
            Integer rating) {
        this.media = media;
        this.status = status;
        this.episodeProgress = episodeProgress;
        this.seasonProgress = seasonProgress;
        this.rating = rating;
    }

    // movie
    public Entry(Media media, Status status, Integer rating) {
        this.media = media;
        this.status = status;
        this.episodeProgress = -1;
        this.seasonProgress = -1;
        this.rating = rating;
    }

    // show no rating
    public Entry(Media media, Status status, Integer episodeProgress, Integer seasonProgress) {
        this.media = media;
        this.status = status;
        this.episodeProgress = episodeProgress;
        this.seasonProgress = seasonProgress;
        this.rating = -1;
    }

    // movie no rating
    public Entry(Media media, Status status) {
        this.media = media;
        this.status = status;
        this.episodeProgress = -1;
        this.seasonProgress = -1;
        this.rating = -1;
    }

    public String getId() {
        return this.id;
    }

    public Media getMedia() {
        return this.media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getEpisodeProgress() {
        return this.episodeProgress;
    }

    public void setEpisodeProgress(Integer episodeProgress) {
        this.episodeProgress = episodeProgress;
    }

    public Integer getSeasonProgress() {
        return this.seasonProgress;
    }

    public void setSeasonProgress(Integer seasonProgress) {
        this.seasonProgress = seasonProgress;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
