package com.hikeup.backend.core.config.exception.exceptions;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 22.01.2024
 **/
public class JwtExpiredOrUntrustedException  extends RuntimeException {

    public JwtExpiredOrUntrustedException(String message) {
        super(message);
    }

    public JwtExpiredOrUntrustedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JwtExpiredOrUntrustedException(Throwable cause) {
        super(cause);
    }
}
