package com.example.demo.Controller;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class TaskDataController {
    @Autowired
    private TaskDataService tservice;


    @GetMapping("/getTasks")
    public List<Task> getTypes(){
        return tservice.getAllTasks();
    }

}
