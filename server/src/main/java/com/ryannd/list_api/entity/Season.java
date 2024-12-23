package com.ryannd.list_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "seasons")
public class Season {
    @Id @UuidGenerator private String id;
    private String title;
    private String source;
    private String sourceId;
    private Integer seasonNumber;
    private Integer episodeCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id")
    private Media sourceMedia;

    @SuppressWarnings("unused")
    private Season() {}

    public Season(
            String title,
            String source,
            String sourceId,
            Integer seasonNumber,
            Integer episodeCount) {
        this.title = title;
        this.source = source;
        this.sourceId = sourceId;
        this.seasonNumber = seasonNumber;
        this.episodeCount = episodeCount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getEpisodeCount() {
        return this.episodeCount;
    }

    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    public Media getSourceMedia() {
        return this.sourceMedia;
    }

    public void setSourceMedia(Media sourceMedia) {
        this.sourceMedia = sourceMedia;
    }
}
