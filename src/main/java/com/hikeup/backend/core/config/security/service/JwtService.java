package com.hikeup.backend.core.config.security.service;

import com.hikeup.backend.core.config.security.util.JwtPropertiesProvider;
import org.springframework.stereotype.Service;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 20.01.2024
 **/

@Service
public class JwtService {

    private final JwtPropertiesProvider jwtPropertiesProvider;

    public JwtService(JwtPropertiesProvider jwtPropertiesProvider) {
        this.jwtPropertiesProvider = jwtPropertiesProvider;
    }

}
