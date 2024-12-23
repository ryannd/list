package com.ryannd.list_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbShow(
        String id,
        String backdrop_path,
        String name,
        String status,
        Integer number_of_seasons,
        String overview,
        String poster_path,
        List<TmdbSeason> seasons) {}
