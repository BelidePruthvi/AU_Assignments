package com.practice.kafkastreams.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberConsumer {

    @KafkaListener(topics="${kafka.topic.even-output}")
    public void consume(Long number) {
        System.out.println("Consumed random No of digits : " + number);
    }
}
