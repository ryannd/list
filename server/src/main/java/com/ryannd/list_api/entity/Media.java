package com.ryannd.list_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "medias")
public class Media {
    @Id @UuidGenerator private String id;

    private String title;
    private String source;
    private String sourceId;

    @Column(columnDefinition = "text")
    private String description;

    private String poster;
    private String type;

    @OneToMany() private List<Season> seasons = new ArrayList<>();

    @SuppressWarnings("unused")
    private Media() {}

    public Media(
            String title,
            String sourceId,
            String source,
            String description,
            String poster,
            String type) {
        this.title = title;
        this.source = source;
        this.sourceId = sourceId;
        this.description = description;
        this.poster = poster;
        this.type = type;
    }

    public Media(
            String title,
            String sourceId,
            String source,
            String description,
            String poster,
            String type,
            List<Season> seasons) {
        this.title = title;
        this.source = source;
        this.sourceId = sourceId;
        this.description = description;
        this.poster = poster;
        this.type = type;
        this.seasons = seasons;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Season> getSeasons() {
        return this.seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
