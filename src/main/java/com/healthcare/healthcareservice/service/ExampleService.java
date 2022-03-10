package com.healthcare.healthcareservice.service;

import java.util.List;

import com.healthcare.healthcareservice.Model.Example;
import com.healthcare.healthcareservice.repository.ExampleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    @Autowired
    ExampleRepository exampleRepository;

    public List<Example> getData() {
        return exampleRepository.findAll();
    }

    public Example addData(int id, String name) {
        Example exm = new Example(id, name);
        System.out.println("======================================"+exm);
        return exampleRepository.save(exm);
    }
    
}
