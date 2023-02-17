package com.smile.smile.services;

import org.springframework.stereotype.Service;

import com.smile.smile.models.Profile;
import com.smile.smile.repositories.ProfileRepository;

import java.util.List;

@Service
public class ProfileService {
    private ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<Profile> getAll() {
        return repository.findAll();
    }
}
