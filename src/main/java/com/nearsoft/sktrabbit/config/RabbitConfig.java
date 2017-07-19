package com.nearsoft.sktrabbit.config;

/**
 * Created by antoniohernandez on 7/17/17.
 */

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue hello() {
        return new Queue("AB");
    }

}
