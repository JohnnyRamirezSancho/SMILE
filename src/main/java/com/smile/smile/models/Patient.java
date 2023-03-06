package com.smile.smile.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
    
    @Id 
    private String dni;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private Date birthdate;
    @OneToOne 
    private Profile profile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "patients_treatments",
        joinColumns = @JoinColumn(name = "patient_dni"),
        inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )
    private List<Treatment> treatments;

    public Patient() {
    }

    public Patient(String dni, String name, String lastname, Date birthdate) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.treatments = new ArrayList<>();
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }   
    
    public void AddTreatments(Treatment treatment){
        this.treatments.add(treatment);
    }
}
