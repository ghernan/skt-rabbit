package com.nearsoft.sktrabbit;

import com.nearsoft.sktrabbit.models.SKTmessage;
import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by antoniohernandez on 7/17/17.
 */
@RabbitListener(queues = "Sky")

public class SKTReceiver {

    @RabbitHandler
    public void receive(String in) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SKTmessage message = mapper.readValue(in, SKTmessage.class);
            System.out.println(" [x] Received '" + message.toString() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
