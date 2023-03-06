package com.smile.smile.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.smile.smile.models.Patient;
import com.smile.smile.repositories.PatientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class PatientRepositoryTest {
    
    @Autowired
    PatientRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("12345678F", "pepe", "perez", Date.valueOf("2008-10-01"));
        Patient storedPatient = repository.save(patient);

        Patient findedPatient = entityManager.find(Patient.class, storedPatient.getDni());

        assertEquals("pepe", findedPatient.getName());
    }

    @Test
    public void testFindByDNI() {
        Patient patient = new Patient("12345678F", "pepe", "perez", Date.valueOf("2008-10-01"));
        repository.save(patient);

        Patient findedPatient = repository.findByDni("12345678F").orElseThrow();

        assertEquals("12345678F",findedPatient.getDni());
    }

    @Test
    public void testDeletePatient(){
        Patient patient = new Patient("12345678F", "pepe", "perez", Date.valueOf("2008-10-01"));
        Integer sizeList= repository.findAll().size();
        
        Patient patientSaved = repository.save(patient);
        repository.delete(patientSaved);

        Integer sizeListPatients = repository.findAll().size();

        assertThat(sizeListPatients, is(equalTo(sizeList)));
    }


}
