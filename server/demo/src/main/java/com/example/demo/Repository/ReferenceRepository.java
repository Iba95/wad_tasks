package com.example.demo.Repository;

import com.example.demo.Model.Reference;
import org.springframework.data.repository.CrudRepository;

public interface ReferenceRepository extends CrudRepository<Reference, Integer> {
    Reference findReferenceByUrl(String url);

}
