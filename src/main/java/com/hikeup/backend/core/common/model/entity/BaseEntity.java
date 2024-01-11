package com.hikeup.backend.core.common.model.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 11.01.2024
 **/
@MappedSuperclass
public abstract class BaseEntity<T> {

    private String _type;
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime updatedDate;

    public BaseEntity() {
        this._type = getClass().getSimpleName();
    }
}
