package com.hikeup.backend.core.config.security.filters;

import com.hikeup.backend.core.config.security.service.JwtService;
import com.hikeup.backend.core.config.security.util.AuthPropertiesProvider;
import com.hikeup.backend.core.config.security.util.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 22.01.2024
 **/
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final JwtProvider jwtProvider;
    private final AuthPropertiesProvider authPropertiesProvider;

    public JwtAuthenticationFilter(AuthPropertiesProvider authPropertiesProvider,
                                   JwtService jwtService,
                                   JwtProvider jwtProvider) {
        this.authPropertiesProvider = authPropertiesProvider;
        this.jwtService = jwtService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader(authPropertiesProvider.getAuthHeader());
        final String token;
        final String username;

        if (authHeader == null || authHeader.startsWith(authPropertiesProvider.getPrefix())) {
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(authPropertiesProvider.getPrefix().length());
        username = jwtProvider.extractUsername(token);

    }
}
