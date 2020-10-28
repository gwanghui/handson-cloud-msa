package com.samsungsds.eshop.nats;

import com.google.gson.Gson;
import io.nats.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.nio.charset.StandardCharsets;
import java.time.Duration;
 
public class NatsPublisher {
    private final Logger logger = LoggerFactory.getLogger(NatsPublisher.class);
    private final Connection natsConnection;
 
    public NatsPublisher(final Connection natsConnection) {
        this.natsConnection = natsConnection;
    }
 
    public <T> void publish(final String topic, T value) {
        String message = new Gson().toJson(value,value.getClass());
        this.publish(topic, message.getBytes(StandardCharsets.UTF_8));
    }
 
    public void publish(final String topic, final byte[] message) {
        try {
            natsConnection.publish(topic, message);
            natsConnection.flush(Duration.ZERO);
            logger.info("NATS message published {}:{}", topic, new String(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
