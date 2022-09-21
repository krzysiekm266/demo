package com.krzysiekm266.demo.task;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
        return args -> {
            Task task1 = new Task("Fix my car",LocalDate.now());
            Task task2 = new Task("Buy new TV",LocalDate.now());

            taskRepository.saveAll(List.of(task1,task2));
        };
    }
    
}
