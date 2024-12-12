package com.example.worker.model;

import com.example.worker.enums.TaskStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task {

    private Long id;

    private String title;

    private TaskStatus status;
}
