package com.smile.smile.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.smile.models.Patient;
import com.smile.smile.models.Profile;
import com.smile.smile.services.PatientService;
import com.smile.smile.payloads.PatientPayload;


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
    // en este metodo del controlador usamos un requestBody de tipo patientPeyLoad para guardar 
    // toda la info que necesitamos para crear a nuestro paciente y su respectivo perfil
    @PostMapping("")
    public void store(@RequestBody Patient patientToAdd){
        service.save(patientToAdd);
    }

    @PostMapping("/{dni}/profiles")
    public void storeProfile(@RequestBody Profile profileToad, @PathVariable String dni){
        
    }

    @DeleteMapping("/{dni}")
    public List<Patient> delete(@PathVariable String dni){
        return service.delete(dni);
    }

    // para hacer el update tambien ultilizamos el payload, solo la parte del patient para modificarlo
    @PutMapping("/{dni}")
    public Patient update(@PathVariable String dni, @RequestBody PatientPayload patientToModify) {
        return service.update(dni, patientToModify);
    }
}