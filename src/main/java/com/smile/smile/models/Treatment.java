package com.smile.smile.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "treatments")
public class Treatment {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_treatment")
    private Long id;
    @Column(nullable = false)
    private String treatment;
    @ManyToMany(mappedBy = "treatments")
    private List<Patient> patients;
    
    public Treatment() {
    }

    public Treatment(Long id, String treatment, List<Patient> patients) {
        this.id = id;
        this.treatment = treatment;
        this.patients = patients;
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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
    
}
