package com.example.demo.Controller;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class TaskDataController {
    @Autowired
    private TaskDataService tservice;


    @GetMapping("/getTasks")
    public @ResponseBody List<Task> getTypes(){
        return tservice.getAllTasks();
    }

    @PostMapping("/addTask")
    public @ResponseBody Task addTask(@RequestBody Task task){
        return tservice.addTask(task);
    }
}
