package com.hikeup.backend.app.accounting.core.service;

import com.hikeup.backend.app.accounting.api.AccountService;
import com.hikeup.backend.app.accounting.core.model.dto.AccountDTO;
import com.hikeup.backend.app.accounting.core.model.dto.AccountResponseDTO;
import com.hikeup.backend.app.accounting.core.model.mapper.AccountMapper;
import com.hikeup.backend.app.accounting.core.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 12.01.2024
 **/
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository,
                              AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountResponseDTO> findAll() {
        return accountRepository.findAll().stream()
                .map(accountMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponseDTO findById(long id) {
        return accountMapper.map(accountRepository.findById(id).orElseThrow(null));
    }

    @Override
    public AccountResponseDTO findByUsername(String username) {
        return accountMapper.map(accountRepository.findByUsername(username).orElseThrow(null));
    }

    @Override
    public ResponseEntity<?> create(AccountDTO account) {
        accountRepository.save(accountMapper.map(account));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
