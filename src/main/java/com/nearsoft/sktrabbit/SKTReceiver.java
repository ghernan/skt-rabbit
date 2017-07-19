package com.nearsoft.sktrabbit;


import com.nearsoft.sktrabbit.models.SKTmessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


/**
 * Created by antoniohernandez on 7/17/17.
 */

public class SKTReceiver {



    @RabbitListener(queues = "AB")
    public void receive(SKTmessage message) {

        System.out.println(" [x] Received '" + message.toString() + "'");


    }

}
