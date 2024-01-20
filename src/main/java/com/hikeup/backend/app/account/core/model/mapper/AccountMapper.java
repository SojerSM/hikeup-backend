package com.hikeup.backend.app.account.core.model.mapper;

import com.hikeup.backend.app.account.core.model.dto.AccountResponseDTO;
import com.hikeup.backend.app.account.core.model.dto.AccountDTO;
import com.hikeup.backend.app.account.core.model.entity.Account;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 12.01.2024
 **/
@Service
public class AccountMapper {

    public AccountResponseDTO map(Account account) {
        AccountResponseDTO mapped = new AccountResponseDTO();
        mapped.setUsername(account.getUsername());
        mapped.setRoles(account.getRoles());
        mapped.setCreatedDate(account.getCreatedDate());
        mapped.setUpdatedDate(account.getUpdatedDate());

        return mapped;
    }

    public Account map(AccountDTO requested) {
        Account account = new Account();
        account.setUsername(requested.getUsername());
        account.setPassword(requested.getPassword());
        account.setRoles(requested.getRoles().isEmpty() ? null : requested.getRoles());
        account.setCreatedDate(LocalDateTime.now());
        account.setUpdatedDate(LocalDateTime.now());

        return account;
    }
}
