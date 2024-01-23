package com.hikeup.backend.app.account.core.model.dto;

import java.time.LocalDateTime;

/**
 * Project: arizona-ecuador
 *
 * @author: sojer
 * @since: 23.01.2024
 */
public class AuthResponseDTO {

    private String accessToken;
    private String refreshToken;
    private LocalDateTime expireAt;

    public AuthResponseDTO() {
        //empty constructor
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }
}
