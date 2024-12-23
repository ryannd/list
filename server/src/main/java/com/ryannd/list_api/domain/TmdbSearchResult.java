package com.ryannd.list_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbSearchResult(
        String backdrop_path,
        String id,
        String title,
        String overview,
        String poster_path,
        String media_type) {}
