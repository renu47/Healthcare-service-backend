package com.healthcare.healthcareservice.repository;

import com.healthcare.healthcareservice.Model.Example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer>{
    
}
