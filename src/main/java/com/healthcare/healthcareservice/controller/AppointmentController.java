package com.healthcare.healthcareservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.healthcare.healthcareservice.Model.Appointment;
import com.healthcare.healthcareservice.service.AppointmentService;

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
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService aService;
	
	@PostMapping("/register")
	public JSONObject registerAppointment(@RequestBody Appointment app){
        JSONObject obj = new JSONObject();
        if(aService.registerAppointment(app))
        obj.put("message", "Booking successful");
        else
        obj.put("message", "Booking failure");
        return obj;
    }

    @GetMapping("/list")
    public List<Appointment> appointmentList(){
        return aService.appointmentList();
    }

    @GetMapping("/view/{appointmentId}")
    public Appointment getAppointment(@PathVariable String appointmentId){
        return aService.getAppointment(appointmentId);
    }

    @GetMapping("/list/{patientid}")
    public List<Appointment> getPatientAppointment(@PathVariable String patientid){
        return aService.getPatientAppointment(patientid);
    }

    @DeleteMapping("/delete/{appointmentId}")
    public boolean deleteAppointment(@PathVariable String appointmentId){
        return aService.deleteAppointment(appointmentId);
    }
}
