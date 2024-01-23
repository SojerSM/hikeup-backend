package com.hikeup.backend.app.account.core.controller;

import com.hikeup.backend.app.account.api.AccountService;
import com.hikeup.backend.app.account.core.model.dto.AccountDTO;
import com.hikeup.backend.app.account.core.model.dto.AccountResponseDTO;
import com.hikeup.backend.app.account.core.service.AccountServiceImpl;
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
    public List<AccountResponseDTO> findAll(@RequestParam(required = false) String username) {
        return accountService.findAll(username);
    }

    @GetMapping("/{id}")
    public AccountResponseDTO findById(@PathVariable("id") long id) {
        return accountService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountDTO account) {
        return accountService.create(account);
    }
}
