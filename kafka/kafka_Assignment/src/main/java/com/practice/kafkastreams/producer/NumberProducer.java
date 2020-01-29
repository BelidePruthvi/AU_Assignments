package com.practice.kafkastreams.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@EnableScheduling
public class NumberProducer {

    @Value("topic1")
    private String topicName;

    @Autowired
    private KafkaTemplate<String,Long> kafkaTemplate;

    Random rand=new Random();
//    private Long counter = 0L;

    @Scheduled(fixedRate = 2000)
    public void produce() {
        kafkaTemplate.send(topicName, rand.nextLong());
    }
}
