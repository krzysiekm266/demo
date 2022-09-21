package com.krzysiekm266.demo.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping
    public List<Task> getTasks() {
        return this.taskService.getAll();
    }

    @PostMapping("/register")
    public String registerTask(@RequestBody Task task) {
        try {
            this.taskService.create(task);
        } catch (IllegalStateException e) {
            return "Error msg: " + e.getMessage() ;
        }
        return "Task registered successfully.";
    }

    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId) {
        try {
            this.taskService.delete(taskId);
        } catch (IllegalStateException e) {
            return "Error msg: " + e.getMessage();
        }
        return "Task deleted successfully.";
    }

    @PutMapping("/update/{taskId}")
    public String updateTask(@PathVariable("taskId") Long taskId,@RequestBody Task task) {
        try {
            this.taskService.update(taskId,task);
        } catch (IllegalStateException e) {
            return "Error msg: "+e.getMessage();
        }
        return "Task updated successfully.";
    }
}  
