package com.nearsoft.sktrabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by antoniohernandez on 7/17/17.
 */
public class SktRabbitRunner implements CommandLineRunner {

    @Value("${app.client.duration:0}")
    private int duration;



    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("Ready ... running for " + duration + "ms");
        //Thread.sleep(duration);
        //ctx.close();
    }
}

