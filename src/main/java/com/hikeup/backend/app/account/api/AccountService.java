package com.hikeup.backend.app.account.api;

import com.hikeup.backend.app.account.core.model.dto.AccountDTO;
import com.hikeup.backend.app.account.core.model.dto.AccountResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
public interface AccountService {

    List<AccountResponseDTO> findAll(String username);
    AccountResponseDTO findById(long id);
    ResponseEntity<?> create(AccountDTO accountDTO);
}