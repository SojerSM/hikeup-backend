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
@ConfigurationProperties(prefix = "jwt")
public class JwtPropertiesProvider {

    private String secretKey;
    private String accessExpDelay;
    private String refreshExpDelay;
    private String prefix;

    public String getSecretKey() {
        return secretKey;
    }

    public String getAccessExpDelay() {
        return accessExpDelay;
    }

    public String getRefreshExpDelay() {
        return refreshExpDelay;
    }

    public String getPrefix() {
        return prefix;
    }
}
