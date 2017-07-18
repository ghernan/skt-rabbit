package com.nearsoft.sktrabbit;

import com.nearsoft.sktrabbit.models.SKTmessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.Queue;
import org.springframework.scheduling.annotation.Scheduled;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        ObjectMapper mapper = new ObjectMapper();
        SKTmessage message =  new SKTmessage("1", "this is message 1");
        String jsonMessage = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
        this.template.convertAndSend(queue.getName(), jsonMessage);
        System.out.println(" [x] Sent '" + jsonMessage + "'");
    }
}
