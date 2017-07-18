package com.nearsoft.sktrabbit;


import com.nearsoft.sktrabbit.models.SKTmessage;
import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by antoniohernandez on 7/17/17.
 */

public class SKTReceiver {



    @RabbitListener(queues = "AB")
    public void receive(SKTmessage message) {

        System.out.println(" [x] Received '" + message.toString() + "'");


    }

}
