package com.nearsoft.sktrabbit;

import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by antoniohernandez on 7/17/17.
 */
@RabbitListener(queues = "SKT")

public class SKTReceiver {

    @RabbitHandler
    public void receive(String in) {

        System.out.println(" [x] Received '" + in + "'");
    }

}
