package com.hikeup.backend.app.accounting.core.model.dto;

import com.hikeup.backend.app.accounting.core.model.enums.Authority;
import com.hikeup.backend.core.common.model.dto.BaseEntityDTO;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 11.01.2024
 **/
public class RoleResponseDTO extends BaseEntityDTO {

    private long id;

    private Authority authority;

    public RoleResponseDTO() {
        // empty constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
