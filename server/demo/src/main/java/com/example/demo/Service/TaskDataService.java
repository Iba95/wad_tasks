package com.example.demo.Service;

import com.example.demo.Model.Status;
import com.example.demo.Model.Task;
import com.example.demo.Repository.StatusRepository;
import com.example.demo.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaskDataService {
    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private StatusRepository statusRepository;

    public List<Task> getAllTasks() {
        return (List<Task>) tasksRepository.findAll();
    }
    public Optional<Status> getStatus(String id) {
        return statusRepository.findById(Integer.parseInt(id));
    }
}
