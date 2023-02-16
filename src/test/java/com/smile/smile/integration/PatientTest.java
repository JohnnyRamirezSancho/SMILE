package com.smile.smile.integration;

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
public class PatientTest {
    
    @Autowired
    PatientRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("12345678F", "pepe", "pepsi", Date.valueOf("2008-10-01"), "935556677", "calle pepe", "villa");
        Patient storedPatient = repository.save(patient);

        Patient findedPatient = entityManager.find(Patient.class, storedPatient.getDni());

        assertEquals("pepe", findedPatient.getName());
    }

    @Test
    public void testFindByDNI() {
        Patient patient = new Patient("12345678F", "pepe", "pepsi", Date.valueOf("2008-10-01"), "935556677", "calle pepe", "villa");
        Patient storedPatient = repository.save(patient);

        Patient findedPatient = repository.findByDni("12345678F");

        assertEquals("12345678F",findedPatient.getDni());
    }

}
