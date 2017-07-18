package com.nearsoft.sktrabbit;

import com.nearsoft.sktrabbit.models.SKTmessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

/**
 * Created by antoniohernandez on 7/17/17.
 */
public class SKTSender {


    @Autowired
    private Queue queue;
    @Autowired
    private ConfigurableApplicationContext ctx;

    @Value("${requests.amount:0}")
    private int requests;
    @Scheduled(fixedDelay = 1000, initialDelay = 500)

    public void send() throws java.io.IOException {

        RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);

        for (int i=1; i <= requests; i++ ){

            SKTmessage message =  new SKTmessage(""+i, "this is message "+ i);
            rabbitTemplate.convertAndSend(queue.getName(), message);
            System.out.println(" [x] Sent '" + message.toString() + "'");
        }
        ctx.close();
    }
}
