package com.hikeup.backend.core.config.security.service;

import com.hikeup.backend.core.config.exception.exceptions.JwtExpiredOrUntrustedException;
import com.hikeup.backend.core.config.security.model.TokenType;
import com.hikeup.backend.core.config.security.util.AuthPropertiesProvider;
import com.hikeup.backend.core.config.security.util.JwtProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 20.01.2024
 **/

@Service
public class JwtService {

    private final AuthPropertiesProvider authPropertiesProvider;
    private final JwtProvider jwtProvider;

    public JwtService(AuthPropertiesProvider authPropertiesProvider,
                      JwtProvider jwtProvider) {
        this.authPropertiesProvider = authPropertiesProvider;
        this.jwtProvider = jwtProvider;
    }

    //TODO should be refactored
    public String generateAccessToken(String username) {
        String delay = authPropertiesProvider.getAccessExpDelay();
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("Type", TokenType.ACCESS);
        return jwtProvider.generateToken(extraClaims, username, Long.parseLong(delay));
    }

    public String generateRefreshToken(String username) {
        String delay = authPropertiesProvider.getRefreshExpDelay();
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("Type", TokenType.REFRESH);
        return jwtProvider.generateToken(extraClaims, username, Long.parseLong(delay));
    }
}
