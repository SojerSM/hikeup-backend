package com.hikeup.backend.app.accounting.api;

import com.hikeup.backend.app.accounting.core.model.dto.RoleResponseDTO;

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
