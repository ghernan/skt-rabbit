package com.nearsoft.sktrabbit;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.Queue;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeoutException;

/**
 * Created by antoniohernandez on 7/17/17.
 */
public class SKTSender {

    @Autowired
    private RabbitTemplate template;
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)

    public void send()
            throws java.io.IOException {

        String message = "Hello World!";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
