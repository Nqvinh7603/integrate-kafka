package com.nqvinh.integrate_kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Consumer {
    @KafkaListener(topics = "${kafka.inbound-topic:first-topic}")
    public void listen(@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) String partition,
                       @Header(KafkaHeaders.RECEIVED_KEY) String key,
                       @Payload String message) {
        log.info("Received Message : " + message);
        try {
            log.info("Processing message {}", message);
        } catch (Exception e) {
            log.error("Error processing message {}", message);
        }
    }
}
