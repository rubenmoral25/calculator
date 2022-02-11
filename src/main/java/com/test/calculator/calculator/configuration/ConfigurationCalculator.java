package com.test.calculator.calculator.configuration;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationCalculator {

    @Bean
    public TracerImpl getTracerImpl(){
        return new TracerImpl();
    }

}
