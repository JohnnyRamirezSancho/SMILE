package com.smile.smile.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.smile.models.Patient;


public interface PatientRepository  extends JpaRepository<Patient, String>{
    public Optional<Patient> findByDni(String dni);   
}