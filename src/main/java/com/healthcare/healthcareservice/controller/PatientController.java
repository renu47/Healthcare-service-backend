package com.healthcare.healthcareservice.controller;

import java.util.ArrayList;
import java.util.List;

import com.healthcare.healthcareservice.Model.Patient;
import com.healthcare.healthcareservice.service.PatientService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService pService;


	@PostMapping("/register")
	public JSONObject registerPatient(@RequestBody Patient patient){
        JSONObject obj = new JSONObject();
        if(pService.registerPatient(patient))
        obj.put("message", "Registration successful");
        else
        obj.put("message", "Registration failure");
        return obj;
    }

    @GetMapping("/list")
    public List<Patient> getList(){
        return pService.getList();
    }

    @GetMapping("/view/{id}")
    public Patient getPatient(@PathVariable String id){
        return pService.getPatient(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePatient(@PathVariable String id){
        return pService.deletePatient(id);
    }

    @GetMapping("/disease/list")
    public JSONObject diseaseList(){
        List<String> list = new ArrayList<>();
        list.add("BP");
        list.add("Sugar");
        list.add("Gastro & Liver");
        JSONObject obj = new JSONObject();
        obj.put("list", list);
        return obj;
    }
}

