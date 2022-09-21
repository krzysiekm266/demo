package com.krzysiekm266.demo.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void create(Task task) {
        Optional<Task> taskByName = this.taskRepository.findByName(task.getName());
        if(taskByName.isPresent()) throw new IllegalStateException("Task name already exist.");
        this.taskRepository.save(task);
    }

    public List<Task> getAll() {
       return this.taskRepository.findAll();
    }
  
    public Optional<Task> get( Long id) {
        return this.taskRepository.findById(id);
    }
    @Transactional
    public String update(Long taskId,Task task) {
        Task taskById = this.taskRepository.findById(taskId)
            .orElseThrow(() ->  new IllegalStateException("Task by " + taskId + " dont exists.") );

        Optional<Task> taskByName = this.taskRepository.findByName(task.getName());
        if(taskByName.isPresent()) {
            throw new IllegalStateException("Task name already exist");
        } 

        taskById.setName(task.getName());
        taskById.setEndDate(task.getEndDate()); 

        return "Task updated successfully.";
    }

    public void delete(Long taskId) {
        Boolean exist = this.taskRepository.existsById(taskId);
        if(!exist) {
            throw new IllegalStateException("Task by "+ taskId + " dont exists.");
        }
        this.taskRepository.deleteById(taskId);
    }
   
}
