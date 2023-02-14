package com.smile.smile.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "treatments")
public class Treatment {
    @OneToOne 
    private Patient dni;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_profile")
    private Long id;
    @Column(nullable = false)
    private String treatment;
    
    public Treatment() {
    }

    public Treatment(Patient dni, Long id, String treatment) {
        this.dni = dni;
        this.id = id;
        this.treatment = treatment;
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
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
}
