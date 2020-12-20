package com.example.demo.Controller;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class TaskDataController {

    @Autowired
    private TaskDataService tservice;


    @GetMapping("/getTasks")
    public List<Task> getTypes(){
        return tservice.getAllTasks();
    }

    @GetMapping("/action=delete&taskId={id}")
    public List<Task> getProducts(@PathVariable String id){
        return tservice.deleteTask(Integer.parseInt(id));
    }

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task){
        return tservice.addTask(task);
    }

    @PutMapping("/action=update&taskId={id}")
    public Task updateTask(@RequestBody Task task){
        return tservice.updateTask(task);
    }

}
