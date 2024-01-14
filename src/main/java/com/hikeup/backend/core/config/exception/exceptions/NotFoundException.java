package com.hikeup.backend.core.config.exception.exceptions;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 14.01.2024
 **/
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
