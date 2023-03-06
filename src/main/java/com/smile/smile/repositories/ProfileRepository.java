package com.smile.smile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.smile.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
    
}
