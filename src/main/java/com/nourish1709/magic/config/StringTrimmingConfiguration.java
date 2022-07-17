package com.nourish1709.magic.config;

import com.nourish1709.magic.postprocessor.StringTrimmingBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringTrimmingConfiguration {

    @Bean
    public StringTrimmingBeanPostProcessor stringTrimmingBeanPostProcessor() {
        return new StringTrimmingBeanPostProcessor();
    }
}
