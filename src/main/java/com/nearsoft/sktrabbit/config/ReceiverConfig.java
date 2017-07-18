package com.nearsoft.sktrabbit.config;

import com.nearsoft.sktrabbit.SKTReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by antoniohernandez on 7/18/17.
 */
@Configuration
public class ReceiverConfig {

    @Profile("receiver")
    @Bean
    public SKTReceiver receiver() {
        return new SKTReceiver();
    }
}
