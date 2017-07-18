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
    private RabbitTemplate template;
    @Autowired
    private Queue queue;
    @Autowired
    private ConfigurableApplicationContext ctx;

    @Value("${requests.amount:0}")
    private int requests;
    @Scheduled(fixedDelay = 1000, initialDelay = 500)

    public void send()
            throws java.io.IOException {
//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Set number of messages: ");
//        int n = reader.nextInt();
        ObjectMapper mapper = new ObjectMapper();
        for (int i=1; i <= requests; i++ ){
            SKTmessage message =  new SKTmessage(""+i, "this is message "+ i);
            String jsonMessage = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
            this.template.convertAndSend(queue.getName(), jsonMessage);
            System.out.println(" [x] Sent '" + jsonMessage + "'");
        }
        ctx.close();
    }
}
