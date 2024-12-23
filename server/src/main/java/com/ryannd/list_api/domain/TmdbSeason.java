package com.ryannd.list_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbSeason(
        String id,
        String name,
        String overview,
        String poster_path,
        Integer season_number,
        Integer episode_count) {}
