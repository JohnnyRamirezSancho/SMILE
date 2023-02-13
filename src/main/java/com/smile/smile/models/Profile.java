package com.smile.smile.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {
    
    @OneToOne 
    private Patient dni;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_profile")
    private Long id;
    @Column(nullable = false)
    private String profile;
    
    public Profile() {
    }

    public Profile(Patient dni, Long id, String profile) {
        this.dni = dni;
        this.id = id;
        this.profile = profile;
    }

    public Patient getDni() {
        return dni;
    }
    public void setDni(Patient dni) {
        this.dni = dni;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }

        
}
