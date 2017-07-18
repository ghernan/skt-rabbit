package com.nearsoft.sktrabbit.config;

import com.nearsoft.sktrabbit.SKTSender;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.amqp.core.Queue;

/**
 * Created by antoniohernandez on 7/18/17.
 */
@Configuration
@Profile("sender")
public class SenderConfig {

    @Autowired
    private Queue queue;
    @Autowired
    private ConnectionFactory factory;


    @Bean
    public SKTSender sender() {
        return new SKTSender();
    }


    @Primary
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(new JsonMessageConverter());
        return template;
    }


}
