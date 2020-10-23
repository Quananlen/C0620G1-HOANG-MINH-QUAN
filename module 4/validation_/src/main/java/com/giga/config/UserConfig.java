package com.giga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public LogUser createLogUser() {
        return new LogUser();
    }
}
