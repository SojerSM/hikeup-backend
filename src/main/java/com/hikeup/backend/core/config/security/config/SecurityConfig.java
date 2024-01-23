package com.hikeup.backend.core.config.security.config;

import com.hikeup.backend.core.config.security.util.AuthPropertiesProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.hikeup.backend.core.config.rest.RestEndpoints.ACCOUNT_BASE;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final AuthPropertiesProvider authPropertiesProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider,
                          AuthPropertiesProvider authPropertiesProvider) {
        this.authenticationProvider = authenticationProvider;
        this.authPropertiesProvider = authPropertiesProvider;
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:8080"));
                    config.setAllowedMethods(List.of("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(List.of("*"));
                    config.setExposedHeaders(List.of(authPropertiesProvider.getAuthHeader()));
                    config.setMaxAge(Duration.of(1L, ChronoUnit.HOURS));
                    return config;
                }))
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers(ACCOUNT_BASE + "/authenticate",
                                        ACCOUNT_BASE + "/register", "/h2-console/**").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider);

        return http.build();
    }
}
