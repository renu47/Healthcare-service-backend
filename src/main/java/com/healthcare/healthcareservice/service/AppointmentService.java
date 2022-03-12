package com.healthcare.healthcareservice.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.healthcare.healthcareservice.Model.Appointment;
import com.healthcare.healthcareservice.repository.AppointmentRepository;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository aRepository;

    public boolean registerAppointment(Appointment app) {
       Appointment a =  aRepository.save(app);
        if(a!=null)
        return true;
        else
        return false;
    }

    public List<Appointment> appointmentList() {
        return aRepository.findAll();
    }

    public Appointment getAppointment(String id) {
        return aRepository.findById(id).get();
    }

    public List<Appointment> getPatientAppointment(String patientid) {
        return aRepository.findByPatientId(patientid);
    }

    public boolean deleteAppointment(String appointmentId) {
        aRepository.deleteById(appointmentId);
        return true;
    }
	
}
