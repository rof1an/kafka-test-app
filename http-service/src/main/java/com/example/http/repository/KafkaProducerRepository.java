package com.example.http.repository;

import com.example.http.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaProducerRepository extends JpaRepository<Task, Long> {
}
