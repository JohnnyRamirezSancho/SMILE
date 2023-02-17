package com.smile.smile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.smile.models.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long>{
    
}
