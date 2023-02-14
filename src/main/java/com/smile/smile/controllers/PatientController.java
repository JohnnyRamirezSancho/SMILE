package com.smile.smile.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.smile.models.Patient;
import com.smile.smile.services.PatientService;

@RestController
@RequestMapping(path = "/api/patients")
public class PatientController {
    private PatientService service;
    
    public PatientController (PatientService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Patient> listAll(){
        return service.getAll();
    }

    @GetMapping("/{dni}")
    public Patient listOne(@PathVariable String dni){
        return service.getOne(dni); 
    }
}