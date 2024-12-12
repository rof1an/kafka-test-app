package com.example.http.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private final String queueTasksTopic = "queue-tasks";

    @Bean
    public NewTopic queueTopic() {
        return TopicBuilder.name(queueTasksTopic)
                .build();
    }
}
