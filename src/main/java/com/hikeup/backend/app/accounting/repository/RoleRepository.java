package com.hikeup.backend.app.accounting.repository;

import com.hikeup.backend.app.accounting.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 11.01.2024
 **/
public interface RoleRepository extends JpaRepository<Role, Long> {
}
