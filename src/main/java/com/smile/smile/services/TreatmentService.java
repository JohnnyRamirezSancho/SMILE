package com.smile.smile.services;

import org.springframework.stereotype.Service;

import com.smile.smile.models.Treatment;
import com.smile.smile.repositories.TreatmentRepository;

import java.util.List;

@Service
public class TreatmentService {
    private TreatmentRepository repository;

    public TreatmentService(TreatmentRepository repository) {
        this.repository = repository;
    }

    public List<Treatment> getAll() {
        return repository.findAll();
    }

    public Treatment save(Treatment treatmentToAdd){
        return repository.save(treatmentToAdd);
    }

    public List<Treatment> delete(Long id){
        repository.deleteById(id);
        return repository.findAll();
    }
}
