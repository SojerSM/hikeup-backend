package com.hikeup.backend.app.accounting.core.controller;

import com.hikeup.backend.app.accounting.api.AccountService;
import com.hikeup.backend.app.accounting.core.model.dto.AccountRequestDTO;
import com.hikeup.backend.app.accounting.core.model.dto.AccountResponseDTO;
import com.hikeup.backend.app.accounting.core.service.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hikeup.backend.core.config.rest.RestEndpoints.ACCOUNT_BASE;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
@RestController
@RequestMapping(ACCOUNT_BASE)
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponseDTO> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponseDTO findById(@PathVariable("id") long id) {
        return accountService.findById(id);
    }

    @GetMapping("/{username}")
    public AccountResponseDTO findByUsername(@PathVariable("username") String username) {
        return accountService.findByUsername(username);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountRequestDTO account) {
        return accountService.create(account);
    }
}
