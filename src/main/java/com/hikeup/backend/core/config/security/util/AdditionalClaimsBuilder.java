package com.hikeup.backend.core.config.security.util;

import com.hikeup.backend.core.config.security.model.TokenType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: arizona-ecuador
 *
 * @author: sojer
 * @since: 23.01.2024
 */
@Component
public class AdditionalClaimsBuilder {

    public Map<String, Object> build(TokenType type) {
        Map<String, Object> additionalClaims = new HashMap<>();
        additionalClaims.put("Type", type);

        return additionalClaims;
    }
}
