package com.hikeup.backend.core.config.security;

import com.hikeup.backend.app.accounting.core.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.hikeup.backend.core.config.rest.RestEndpoints.API_URL;

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

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(List.of("http://localhost:3000"));
                    configuration.setAllowedMethods(List.of("*"));
                    configuration.setAllowCredentials(true);
                    configuration.setAllowedHeaders(List.of("*"));
                    configuration.setMaxAge(Duration.of(1L, ChronoUnit.HOURS));
                    return configuration;
                }))
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(requests ->
                        requests
                                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
