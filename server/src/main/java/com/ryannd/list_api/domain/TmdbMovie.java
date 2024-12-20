package com.ryannd.list_api.domain;

public record TmdbMovie(
        Integer id,
        String title,
        String release_date,
        Integer runtime,
        String poster_path,
        String backdrop_path,
        String overview) {}
