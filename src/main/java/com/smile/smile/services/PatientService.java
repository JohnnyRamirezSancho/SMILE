package com.smile.smile.services;

import org.springframework.stereotype.Service;

import com.smile.smile.models.Patient;
import com.smile.smile.repositories.PatientRepository;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public List<Patient> getAll() {
        return repository.findAll();
    }
    
    public Patient getOne(String dni) {
        return repository.findByDni(dni);
    }

}
