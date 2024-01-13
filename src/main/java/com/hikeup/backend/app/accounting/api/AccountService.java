package com.hikeup.backend.app.accounting.api;

import com.hikeup.backend.app.accounting.core.model.dto.AccountRequestDTO;
import com.hikeup.backend.app.accounting.core.model.dto.AccountResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
public interface AccountService {

    List<AccountResponseDTO> findAll();
    AccountResponseDTO findById(long id);
    AccountResponseDTO findByUsername(String username);
    ResponseEntity<?> create(AccountRequestDTO accountRequestDTO);
}
