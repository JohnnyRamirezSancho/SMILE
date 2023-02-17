package com.smile.smile.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.smile.models.Treatment;
import com.smile.smile.services.TreatmentService;

@RestController
@RequestMapping(path = "/api/treatments")
public class TreatmentController {
    private TreatmentService service;
    
    public TreatmentController (TreatmentService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Treatment> listAll(){
        return service.getAll();
    }

}