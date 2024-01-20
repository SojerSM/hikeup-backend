package com.hikeup.backend.app.account.core.controller;

import com.hikeup.backend.app.account.core.model.dto.AccountAuthRequestDTO;
import com.hikeup.backend.app.account.core.model.dto.AccountRegisterRequestDTO;
import com.hikeup.backend.app.account.core.service.access.AuthenticationService;
import com.hikeup.backend.app.account.core.service.access.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hikeup.backend.core.config.rest.RestEndpoints.ACCOUNT_BASE;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/

@RestController
@RequestMapping(value = ACCOUNT_BASE)
public class AccessController {

    private final AuthenticationService authenticationService;
    private final RegistrationService registrationService;

    public AccessController(AuthenticationService authenticationService, RegistrationService registrationService) {
        this.authenticationService = authenticationService;
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody @Validated AccountAuthRequestDTO request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody @Validated AccountRegisterRequestDTO request) {
        return ResponseEntity.ok(registrationService.register(request));
    }
}
