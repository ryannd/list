package com.ryannd.list_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfiguration {
    @Bean
    public WebClient webClientBuilder() {
        return WebClient.builder().build();
    }
}
