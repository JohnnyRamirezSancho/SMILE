package com.smile.smile.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.smile.models.Profile;
import com.smile.smile.services.ProfileService;

@RestController
@RequestMapping(path = "/api/profiles")
public class ProfileController {
    private ProfileService service;
    
    public ProfileController (ProfileService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Profile> listAll(){
        return service.getAll();
    }

}