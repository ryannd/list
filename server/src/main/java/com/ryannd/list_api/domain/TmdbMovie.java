package com.ryannd.list_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbMovie(
        Integer id,
        String title,
        String release_date,
        Integer runtime,
        String poster_path,
        String backdrop_path,
        String overview) {}
