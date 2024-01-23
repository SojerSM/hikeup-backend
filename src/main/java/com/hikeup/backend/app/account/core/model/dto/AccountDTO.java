package com.hikeup.backend.app.account.core.model.dto;

import com.hikeup.backend.app.account.core.model.entity.Role;

import java.util.List;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 12.01.2024
 **/
public class AccountDTO {

    private String username;
    private String password;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
