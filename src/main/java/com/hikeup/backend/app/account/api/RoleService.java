package com.hikeup.backend.app.account.api;

import com.hikeup.backend.app.account.core.model.dto.RoleResponseDTO;

import java.util.List;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 13.01.2024
 **/
public interface RoleService {

    List<RoleResponseDTO> findAll();
}
