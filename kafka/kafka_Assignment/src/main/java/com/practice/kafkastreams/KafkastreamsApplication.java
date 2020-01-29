package com.practice.kafkastreams;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkastreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkastreamsApplication.class, args);
	}

}
