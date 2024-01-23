package com.hikeup.backend.app.account.core.service.access;

import com.hikeup.backend.app.account.api.AccountService;
import com.hikeup.backend.app.account.core.model.dto.AccountResponseDTO;
import com.hikeup.backend.app.account.core.model.dto.AuthRequestDTO;
import com.hikeup.backend.app.account.core.model.dto.AuthResponseDTO;
import com.hikeup.backend.app.account.core.util.AuthResponseBuilder;
import com.hikeup.backend.core.config.security.service.JwtGenerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
@Service
public class AuthenticationService {

    private final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    private final AuthenticationManager authenticationManager;
    private final JwtGenerationService jwtGenerationService;
    private final AuthResponseBuilder authResponseBuilder;
    private final AccountService accountService;

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 JwtGenerationService jwtGenerationService,
                                 AuthResponseBuilder authResponseBuilder,
                                 AccountService accountService) {
        this.authenticationManager = authenticationManager;
        this.jwtGenerationService = jwtGenerationService;
        this.authResponseBuilder = authResponseBuilder;
        this.accountService = accountService;
    }

    public ResponseEntity<AuthResponseDTO> authenticate(AuthRequestDTO request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword())
            );
        } catch (AuthenticationException e) {
            logger.warn("Failed to authenticate user - {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        AccountResponseDTO authenticated = accountService.findAll(request.getUsername()).get(0);
        String accessToken = jwtGenerationService.generateAccessToken(request.getUsername(), authenticated.getRoles());
        String refreshToken = jwtGenerationService.generateRefreshToken(request.getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(
                authResponseBuilder.build(accessToken,refreshToken));
    }
}
