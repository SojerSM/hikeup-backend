package com.hikeup.backend.core.config.exception;

import com.hikeup.backend.core.common.model.dto.CustomExceptionResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 14.01.2024
 **/
@Component
public class DefaultExceptionResponseProvider {

    public CustomExceptionResponseDTO generate(String message) {
        return new CustomExceptionResponseDTO(message, LocalDateTime.now());
    }
}
