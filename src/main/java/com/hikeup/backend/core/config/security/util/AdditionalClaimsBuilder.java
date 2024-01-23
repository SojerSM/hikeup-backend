package com.hikeup.backend.core.config.security.util;

import com.hikeup.backend.app.account.core.model.entity.Role;
import com.hikeup.backend.app.account.core.model.enums.Authority;
import com.hikeup.backend.core.config.security.model.TokenType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 23.01.2024
 **/
@Component
public class AdditionalClaimsBuilder {

    public Map<String, Object> build(TokenType type) {
        Map<String, Object> additionalClaims = new HashMap<>();
        additionalClaims.put("type", type);

        return additionalClaims;
    }

    public Map<String, Object> build(TokenType type, List<Role> roles) {
        List<Authority> authorities = roles.stream()
                .map(Role::getAuthority)
                .toList();

        Map<String, Object> additionalClaims = this.build(type);
        additionalClaims.put("authorities", authorities);

        return additionalClaims;
    }
}
