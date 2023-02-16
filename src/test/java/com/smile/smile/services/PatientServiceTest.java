package com.smile.smile.services;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.smile.smile.models.Patient;
import com.smile.smile.models.Profile;
import com.smile.smile.repositories.PatientRepository;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {


    @InjectMocks
    PatientService service;

    @Mock
    PatientRepository repository;

    @Test
    public void test_get_all(){
       Profile profile1 = new Profile(1L, "elevenprofile", "1234567890", "calle coca cola", "ciudad");
       Profile profile2 = new Profile(2L, "oneprofile", "1234531230", "calle coca cola no", "ciudad2");
       Patient patient1 = new Patient("3434343434l", "Eleven", "Twelve", Date.valueOf("2013-04-04"), profile1);
       Patient patient2 = new Patient("3543343434l", "one", "Twelve", Date.valueOf("2018-04-04"),profile2); 

       List<Patient> patients = new ArrayList<>();

       patients.add(patient2);
       patients.add(patient1);

       when(repository.findAll()).thenReturn(patients);

       List<Patient> reponsePatientsTest = service.getAll();

       assertThat(reponsePatientsTest.size()).isEqualTo(2);
       assertThat(reponsePatientsTest.get(0).getName()).isEqualTo("one");

    }

    @Test
    public void test_get_one_patient(){
        Profile profile = new Profile(1L, "elevenprofile", "1234567890", "calle coca cola", "ciudad");
        Patient patient = new Patient("3434343434l", "Eleven", "Twelve", Date.valueOf("2013-04-04"),profile);

        when(repository.findByDni("3434343434l")).thenReturn(patient);

        service.getOne("3434343434l");

        assertThat(patient.getDni()).isEqualTo("3434343434l");
    }
}
