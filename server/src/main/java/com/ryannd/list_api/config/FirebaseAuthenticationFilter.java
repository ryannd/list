package com.ryannd.list_api.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class FirebaseAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (isAllowedRoute(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        String idToken = request.getHeader(WebConstants.AUTHORIZATION_HEADER);

        if (idToken == null || idToken.isEmpty()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing Firebase ID-Token");
            return;
        }

        try {
            FirebaseToken token =
                    FirebaseAuth.getInstance().verifyIdToken(idToken.replace("Bearer ", ""));

            String email = token.getEmail();
            String name = (String) token.getClaims().get("name");

            List<GrantedAuthority> authorities = getAuthoritiesFromToken(token);

            SecurityContextHolder.getContext()
                    .setAuthentication(
                            new FirebaseAuthenticationToken(idToken, token, authorities));

            request.setAttribute("email", email);
            request.setAttribute("name", name);

            SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Firebase ID-Token");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private static List<GrantedAuthority> getAuthoritiesFromToken(FirebaseToken token) {
        Object claims = token.getClaims().get("authorities");
        @SuppressWarnings("unchecked")
        List<String> permissions = (List<String>) claims;

        List<GrantedAuthority> authorities = AuthorityUtils.NO_AUTHORITIES;

        if (permissions != null && !permissions.isEmpty()) {
            authorities = AuthorityUtils.createAuthorityList(permissions);
        }
        return authorities;
    }

    private boolean isAllowedRoute(String requestUri) {
        // Check if the request URI matches any of the allowed routes
        return WebConstants.PUBLIC_ROUTES.stream()
                .anyMatch(route -> requestUri.startsWith(route.replace("/**", "")));
    }
}
