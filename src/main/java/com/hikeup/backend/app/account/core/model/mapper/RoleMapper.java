package com.hikeup.backend.app.account.core.model.mapper;

import com.hikeup.backend.app.account.core.model.entity.Role;
import com.hikeup.backend.app.account.core.model.dto.RoleResponseDTO;
import org.springframework.stereotype.Service;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 11.01.2024
 **/
@Service
public class RoleMapper {

    public RoleResponseDTO map(Role role) {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setId(role.getId());
        roleResponseDTO.setAuthority(role.getAuthority());
        roleResponseDTO.setCreatedDate(role.getCreatedDate());
        roleResponseDTO.setUpdatedDate(role.getUpdatedDate());

        return roleResponseDTO;
    }
}
