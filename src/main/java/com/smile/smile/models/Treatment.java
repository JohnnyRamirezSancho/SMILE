package com.smile.smile.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "treatments")
public class Treatment {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_treatment")
    private Long id;
    @Column(nullable = false)
    private String treatment;

    
    public Treatment() {
    }

    public Treatment(Long id, String treatment) {
        this.id = id;
        this.treatment = treatment;
        
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
