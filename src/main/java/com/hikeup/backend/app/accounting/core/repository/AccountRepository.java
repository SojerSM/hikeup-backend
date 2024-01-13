package com.hikeup.backend.app.accounting.core.repository;

import com.hikeup.backend.app.accounting.core.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 12.01.2024
 **/
public interface AccountRepository extends JpaRepository<Account, Long> {
}
