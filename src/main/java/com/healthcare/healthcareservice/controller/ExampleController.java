package com.healthcare.healthcareservice.controller;

import java.util.List;

import com.healthcare.healthcareservice.Model.Example;
import com.healthcare.healthcareservice.service.ExampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @Autowired
    ExampleService exmService;

    @GetMapping("/get")
    public List<Example> getData(){
        return exmService.getData();
    }

    @PostMapping("/add")
    public Example postData(@RequestParam int id, @RequestParam String name){
        return exmService.addData(id, name);
    }
}
