package com.hikeup.backend.app.accounting.core.model.entity;

import com.hikeup.backend.app.accounting.core.model.enums.Authority;
import com.hikeup.backend.core.common.model.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 11.01.2024
 **/
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private Authority authority;

    public Role() {
    }

    public Role(Authority authority) {
        this.authority = authority;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
