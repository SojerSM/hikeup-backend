package com.hikeup.backend.core.config.security.service;

import com.hikeup.backend.app.account.core.model.entity.Role;
import com.hikeup.backend.core.config.security.model.TokenType;
import com.hikeup.backend.core.config.security.util.AdditionalClaimsBuilder;
import com.hikeup.backend.core.config.security.util.AuthPropertiesProvider;
import com.hikeup.backend.core.config.security.util.JwtDetailsProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 20.01.2024
 **/

@Service
public class JwtGenerationService {

    private final AuthPropertiesProvider authPropertiesProvider;
    private final JwtDetailsProvider jwtDetailsProvider;
    private final AdditionalClaimsBuilder additionalClaimsBuilder;

    public JwtGenerationService(AuthPropertiesProvider authPropertiesProvider,
                                JwtDetailsProvider jwtDetailsProvider,
                                AdditionalClaimsBuilder additionalClaimsBuilder) {
        this.authPropertiesProvider = authPropertiesProvider;
        this.jwtDetailsProvider = jwtDetailsProvider;
        this.additionalClaimsBuilder = additionalClaimsBuilder;
    }

    public String generateAccessToken(String username, List<Role> roles) {
        String delay = authPropertiesProvider.getAccessExpDelay();
        Map<String, Object> additionalClaims = additionalClaimsBuilder.build(TokenType.ACCESS, roles);
        return jwtDetailsProvider.generateToken(additionalClaims, username, Long.parseLong(delay));
    }

    public String generateRefreshToken(String username) {
        String delay = authPropertiesProvider.getRefreshExpDelay();
        Map<String, Object> additionalClaims = additionalClaimsBuilder.build(TokenType.REFRESH);
        return jwtDetailsProvider.generateToken(additionalClaims, username, Long.parseLong(delay));
    }
}
