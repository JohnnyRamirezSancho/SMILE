package com.smile.smile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.smile.models.Patient;

public interface PatientRepository  extends JpaRepository<Patient, String>{
    public Patient findByDni(String dni);    
}