package com.healthcare.healthcareservice.repository;

import org.springframework.stereotype.Repository;

import com.healthcare.healthcareservice.Model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PatientRepository extends JpaRepository<Patient,String>{

}

