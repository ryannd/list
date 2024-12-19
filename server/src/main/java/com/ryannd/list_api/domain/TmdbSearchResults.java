package com.ryannd.list_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbSearchResults(Integer page, List<SearchResults> results) {
    public record SearchResults(
            String backdrop_path,
            Integer id,
            String title,
            String overview,
            String poster_path,
            String media_type) {}
}
