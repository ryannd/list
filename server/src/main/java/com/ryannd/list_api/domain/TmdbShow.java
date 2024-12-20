package com.ryannd.list_api.domain;

import java.util.List;

public record TmdbShow(
        Integer id,
        String backdrop_path,
        String name,
        String status,
        Integer number_of_seasons,
        String overview,
        List<TmdbSeason> seasons) {}

record TmdbSeason(
        Integer id,
        String name,
        String overview,
        String poster_path,
        Integer season_number,
        Integer episode_count) {}
