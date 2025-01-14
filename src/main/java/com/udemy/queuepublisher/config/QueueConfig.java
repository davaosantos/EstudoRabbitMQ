package com.udemy.queuepublisher.config;

import com.google.gson.Gson;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QueueConfig {

    @Bean
    public Gson getGson(){
        return new Gson();
    }

    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of("com.udemy.queuepublisher.domain.*", "java.util.*"));
        return converter;
    }
}
