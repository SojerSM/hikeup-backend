package com.hikeup.backend.app.account.core.service.access;

import com.hikeup.backend.app.account.core.model.dto.AccountRegisterRequestDTO;
import com.hikeup.backend.app.account.core.repository.AccountRepository;
import com.hikeup.backend.app.account.core.util.AccountCreationProvider;
import org.springframework.stereotype.Service;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
@Service
public class RegistrationService {

    private final AccountRepository accountRepository;
    private final AccountCreationProvider accountCreationProvider;

    public RegistrationService(AccountRepository accountRepository,
                               AccountCreationProvider accountCreationProvider) {
        this.accountRepository = accountRepository;
        this.accountCreationProvider = accountCreationProvider;
    }

    //TODO should returns custom RegisterResponse when JWT implemented.
    public String register(AccountRegisterRequestDTO request) {
        if (accountRepository.findByUsername(request.getUsername()).isPresent()) {
            return "User already exists";
        }

        accountRepository.save(accountCreationProvider.build(request));

        return "User registered.";
    }
}
