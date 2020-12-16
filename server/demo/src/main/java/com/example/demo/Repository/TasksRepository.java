package com.example.demo.Repository;

import com.example.demo.Model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, Integer> {
}
