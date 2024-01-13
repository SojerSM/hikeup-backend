package com.hikeup.backend.app.accounting.core.model.dto;

import com.hikeup.backend.app.accounting.core.model.entity.Role;
import com.hikeup.backend.core.common.model.dto.BaseEntityDTO;

import java.util.List;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 12.01.2024
 **/
public class AccountResponseDTO extends BaseEntityDTO {

    private String username;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
