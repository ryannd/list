package com.ryannd.list_api.config;

import java.util.Arrays;
import java.util.List;

public final class WebConstants {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String API_BASE_PATH = "/api/**";

    public static final List<String> PUBLIC_ROUTES = Arrays.asList("/api/details/**");

    private WebConstants() {}
}
