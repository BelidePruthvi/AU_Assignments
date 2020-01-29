package com.practice.kafkastreams.processor;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberProcessor {

    @Value("${kafka.topic.even-output}")
    private String outputEvenTopicName;

    public void process(KStream<String, Long> stream){
        stream.filter((k, v) -> v % 2 != 0)
                .mapValues(v -> {
                    System.out.println("Random odd number  :: " + v);
                    return noOfDigits(v);
                })
                .to(outputEvenTopicName);
    }

    public Long noOfDigits(Long v){
        Long nofodigits=0L;
        while(v!=0)
        {
            v=v/10;
            nofodigits+=1;
        }
        return nofodigits;
    }
}
