package com.ryannd.list_api.service;

import com.ryannd.list_api.domain.TmdbSearchResults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

@Service
public class TmdbService {
    @Value("${tmdbKey}")
    private String apiKey;

    private final WebClient webClient;

    private WebClient.RequestHeadersUriSpec<?> getWithAuth() {
        return (RequestHeadersUriSpec<?>)
                webClient
                        .get()
                        .header("accept", "application/json")
                        .header("Authorization", "Bearer " + apiKey);
    }

    public TmdbService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.themoviedb.org/3").build();
    }

    public TmdbSearchResults searchMovies(String query) {
        return getWithAuth()
                .uri(
                        uriBuilder ->
                                uriBuilder.path("/search/movie").queryParam("query", query).build())
                .retrieve()
                .bodyToMono(TmdbSearchResults.class)
                .block();
    }

    public TmdbSearchResults searchShows(String query) {
        return getWithAuth()
                .uri(uriBuilder -> uriBuilder.path("/search/tv").queryParam("query", query).build())
                .retrieve()
                .bodyToMono(TmdbSearchResults.class)
                .block();
    }

    public TmdbSearchResults searchAll(String query) {
        // TODO: filter people out
        return getWithAuth()
                .uri(
                        uriBuilder ->
                                uriBuilder.path("/search/multi").queryParam("query", query).build())
                .retrieve()
                .bodyToMono(TmdbSearchResults.class)
                .block();
    }
}
