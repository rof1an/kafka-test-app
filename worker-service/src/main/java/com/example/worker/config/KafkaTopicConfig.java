package com.example.worker.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private final String processedTasksTopic = "processed-tasks";

    @Bean
    public NewTopic processTopic() {
        return TopicBuilder.name(processedTasksTopic)
                .build();
    }
}
