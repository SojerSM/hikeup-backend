package com.hikeup.backend.core.config.security.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 20.01.2024
 **/
@Component
@ConfigurationProperties(prefix = "security.jwt")
public class AuthPropertiesProvider {

    private String secretKey;
    private String accessExpDelay;
    private String refreshExpDelay;
    private String prefix;
    private String authHeader;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAccessExpDelay() {
        return accessExpDelay;
    }

    public void setAccessExpDelay(String accessExpDelay) {
        this.accessExpDelay = accessExpDelay;
    }

    public String getRefreshExpDelay() {
        return refreshExpDelay;
    }

    public void setRefreshExpDelay(String refreshExpDelay) {
        this.refreshExpDelay = refreshExpDelay;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getAuthHeader() {
        return authHeader;
    }

    public void setAuthHeader(String authHeader) {
        this.authHeader = authHeader;
    }
}
