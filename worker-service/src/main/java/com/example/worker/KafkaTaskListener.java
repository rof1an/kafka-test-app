package com.example.worker;

import com.example.worker.enums.TaskStatus;
import com.example.worker.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class KafkaTaskListener {

    private final Random random = new Random();
    private final KafkaTemplate<String, Task> kafkaTemplate;

    @KafkaListener(topics = "queue-tasks", groupId = "groupId")
    void listener(Task task, @Headers Map<String, Object> headers) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5000);

        headers.forEach((key, value) -> System.out.println("HEADERS2 " + key + ": " + value));

        TaskStatus taskStatus = TaskStatus.FINISHED;
        if (random.nextInt(7) == 5) {
            taskStatus = TaskStatus.ERROR;
        }
        task.setStatus(taskStatus);

        kafkaTemplate.send("processed-tasks", task);
    }
}
