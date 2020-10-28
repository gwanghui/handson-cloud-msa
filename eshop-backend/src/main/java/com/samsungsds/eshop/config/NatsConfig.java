package com.samsungsds.eshop.config;

import io.nats.client.Connection;

import com.samsungsds.eshop.nats.NatsPublisher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class NatsConfig {
    @Bean
    NatsPublisher natsPublisher(Connection natsConnection) {
        return new NatsPublisher(natsConnection);
    }
}
