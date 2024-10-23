package com.nqvinh.integrate_kafka;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE ,makeFinal = true)
public class Producer {

    KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String key ,String value) throws ExecutionException, InterruptedException {
        kafkaTemplate.send(topic, key, value); //async
        //SendResult<String, String> sendResult = kafkaTemplate.send(topic, key, value).get(); //sync
    }
}
