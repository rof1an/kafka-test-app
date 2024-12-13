package com.example.http.service;

import com.example.http.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.swing.text.TabSet;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Task> kafkaTemplate;

    public void sendMessage(String topic, Task message) {
        kafkaTemplate.send(topic, message);
    }
}
