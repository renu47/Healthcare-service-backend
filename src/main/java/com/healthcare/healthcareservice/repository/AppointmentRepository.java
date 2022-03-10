package com.healthcare.healthcareservice.repository;

import com.healthcare.healthcareservice.Model.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,String>{

}
