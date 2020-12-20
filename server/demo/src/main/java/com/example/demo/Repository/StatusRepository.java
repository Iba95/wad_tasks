package com.example.demo.Repository;

import com.example.demo.Model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StatusRepository extends CrudRepository<Status, Integer>{
    Status findByStatus(String status);
}
