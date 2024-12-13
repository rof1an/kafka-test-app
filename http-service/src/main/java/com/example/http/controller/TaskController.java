package com.example.http.controller;

import com.example.http.entity.Task;
import com.example.http.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tasks")
public class TaskController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestBody Task task) {
        kafkaProducerService.sendMessage(topic, task);
        return "Message sent to Kafka topic: " + topic + " with message " + task.getTitle();
    }
}
