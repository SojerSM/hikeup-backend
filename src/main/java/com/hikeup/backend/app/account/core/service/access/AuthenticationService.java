package com.hikeup.backend.app.account.core.service.access;

import com.hikeup.backend.app.account.api.AccountService;
import com.hikeup.backend.app.account.core.model.dto.AccountResponseDTO;
import com.hikeup.backend.app.account.core.model.dto.AuthRequestDTO;
import com.hikeup.backend.app.account.core.model.dto.AuthResponseDTO;
import com.hikeup.backend.app.account.core.model.entity.Account;
import com.hikeup.backend.app.account.core.model.mapper.AccountMapper;
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
    private final AccountService accountService;

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 JwtService jwtService,
                                 AuthResponseBuilder authResponseBuilder,
                                 AccountService accountService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.authResponseBuilder = authResponseBuilder;
        this.accountService = accountService;
    }

    public ResponseEntity<AuthResponseDTO> authenticate(AuthRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword())
        );

        AccountResponseDTO authenticated = accountService.findAll(request.getUsername()).get(0);
        String accessToken = jwtService.generateAccessToken(request.getUsername(), authenticated.getRoles());
        String refreshToken = jwtService.generateRefreshToken(request.getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(
                authResponseBuilder.build(accessToken,refreshToken));
    }
}
