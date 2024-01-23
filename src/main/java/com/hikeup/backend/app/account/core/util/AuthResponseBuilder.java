package com.hikeup.backend.app.account.core.util;

import com.hikeup.backend.app.account.core.model.dto.AuthResponseDTO;
import com.hikeup.backend.core.config.security.util.AuthPropertiesProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 23.01.2024
 **/
@Component
public class AuthResponseBuilder {

    private final AuthPropertiesProvider authPropertiesProvider;

    public AuthResponseBuilder(AuthPropertiesProvider authPropertiesProvider) {
        this.authPropertiesProvider = authPropertiesProvider;
    }

    public AuthResponseDTO build(String accessToken, String refreshToken) {
        AuthResponseDTO response = new AuthResponseDTO();
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        response.setExpireAt(LocalDateTime.now().plus(
                Long.parseLong(authPropertiesProvider.getAccessExpDelay()), ChronoUnit.MILLIS));

        return response;
    }
}
