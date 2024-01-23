package com.hikeup.backend.app.account.core.service.access;

import com.hikeup.backend.app.account.core.model.dto.AuthRequestDTO;
import com.hikeup.backend.app.account.core.model.dto.AuthResponseDTO;
import com.hikeup.backend.app.account.core.util.AuthResponseBuilder;
import com.hikeup.backend.core.config.security.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthResponseBuilder authResponseBuilder;

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 JwtService jwtService,
                                 AuthResponseBuilder authResponseBuilder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.authResponseBuilder = authResponseBuilder;
    }

    public ResponseEntity<AuthResponseDTO> authenticate(AuthRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword())
        );

        String accessToken = jwtService.generateAccessToken(request.getUsername());
        String refreshToken = jwtService.generateRefreshToken(request.getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(authResponseBuilder.build(accessToken,refreshToken));
    }
}
