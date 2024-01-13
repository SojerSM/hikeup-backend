package com.hikeup.backend.app.accounting.core.util;

import com.hikeup.backend.app.accounting.core.model.dto.AccountRegisterRequestDTO;
import com.hikeup.backend.app.accounting.core.model.entity.Account;
import com.hikeup.backend.app.accounting.core.model.entity.Role;
import com.hikeup.backend.app.accounting.core.model.enums.Authority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
@Component
public class AccountCreationProvider {

    private final PasswordEncoder passwordEncoder;

    public AccountCreationProvider(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Account build(AccountRegisterRequestDTO request) {
        Account registered = new Account();
        registered.setUsername(request.getUsername());
        registered.setPassword(passwordEncoder.encode(request.getPassword()));
        registered.setCreatedDate(LocalDateTime.now());
        registered.setUpdatedDate(null);
        registered.setRoles(List.of(new Role(Authority.ADMIN)));

        return registered;
    }
}
