package com.nqvinh.integrate_kafka;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProducerTest implements CommandLineRunner {

    @Value("${kafka.outbound-topic:first-topic}")
    String topic;

    final Producer producer;

    @Override
    public void run(String... args) throws Exception {
        Thread.sleep(5000);
        producer.send(topic, "m1", "test");
    }
}
