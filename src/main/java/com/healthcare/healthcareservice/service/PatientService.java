package com.healthcare.healthcareservice.service;

import java.util.Date;
import java.util.List;

import com.healthcare.healthcareservice.Model.Patient;
import com.healthcare.healthcareservice.repository.PatientRepository;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {
    @Autowired
    PatientRepository pRepository;

    public boolean registerPatient(Patient patient) {
        Patient p = pRepository.save(patient);
        if(p != null)
        return true;
        else
        return false;
    }

    public List<Patient> getList() {
        List<Patient> pList = pRepository.findAll();
        return pList;
    }

    public Patient getPatient(String id) {
        Patient p = pRepository.findById(id).get();
        return p;
    }

    public boolean deletePatient(String id) {
        pRepository.deleteById(id);
        return true;
    }

}

