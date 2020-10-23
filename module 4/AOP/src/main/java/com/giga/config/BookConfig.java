package com.giga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {
    @Bean
    public LogBook createLogBook() {
        return new LogBook();
    }
}
