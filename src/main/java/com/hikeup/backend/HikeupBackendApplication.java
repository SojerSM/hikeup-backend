package com.hikeup.backend;

import com.hikeup.backend.core.config.security.util.AuthPropertiesProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AuthPropertiesProvider.class)
public class HikeupBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HikeupBackendApplication.class, args);
    }

}
