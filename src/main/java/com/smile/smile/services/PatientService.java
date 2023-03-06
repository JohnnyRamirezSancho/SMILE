package com.smile.smile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smile.smile.models.Patient;
import com.smile.smile.models.Profile;
import com.smile.smile.models.Treatment;
import com.smile.smile.repositories.PatientRepository;
import com.smile.smile.repositories.ProfileRepository;
import com.smile.smile.repositories.TreatmentRepository;


import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientService {

    private PatientRepository repository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public List<Patient> getAll() {
        return repository.findAll();
    }
    
    public Patient getOne(String dni) {
        return repository.findByDni(dni).orElseThrow(null);
    }

    public void save(Patient patientToAdd){
        Patient newPatient = new Patient(patientToAdd
                            .getDni()
                            , patientToAdd.getName()
                            , patientToAdd.getLastname()
                            , patientToAdd.getBirthdate());      
        repository.save(newPatient);
    }

    public void saveProfile(Profile profileToAdd, String dni){
        Patient patientAddProfile = repository.findByDni(dni).orElseThrow();

        profileRepository.save(profileToAdd);
        patientAddProfile.setProfile(profileToAdd);

        repository.save(patientAddProfile);
    }

    public void saveTreatment(Treatment treatmentToAdd, String dni) {
        Patient patientAddTreatment = repository.findByDni(dni).orElseThrow();
        Treatment treatmentAddPatient= treatmentRepository.findById(treatmentToAdd.getId()).orElseThrow();


        patientAddTreatment.AddTreatments(treatmentAddPatient);


        repository.save(patientAddTreatment);
    }

    public List<Patient> delete(String dni){

        Patient patientToDelete = repository.findByDni(dni).orElse(null);
        repository.delete(patientToDelete);
        // profileRepository.delete(patientToDelete.getProfile());
        return repository.findAll();
    }

    public Patient update(String dni, Patient patientToUpdate){

        return repository.findByDni(dni).map(patientPayload -> {

            patientPayload.setName(patientToUpdate.getName());
            patientPayload.setLastname(patientToUpdate.getLastname());
            patientPayload.setBirthdate(patientToUpdate.getBirthdate());

            return repository.save(patientPayload);
        }).orElse(null);
    }

    public Profile updateProfile(String dni, Profile profileToUpdate){
           
            Patient patientProfileToUpdate = repository.findByDni(dni).orElseThrow(null);

            Profile profileUpdated = patientProfileToUpdate.getProfile();

            profileUpdated.setProfile(profileToUpdate.getProfile());
            profileUpdated.setPhone(profileToUpdate.getPhone());
            profileUpdated.setAddress(profileToUpdate.getAddress());
            profileUpdated.setCity(profileToUpdate.getCity());
            
            return repository.save(patientProfileToUpdate).getProfile();
    }

    public Patient deleteProfile(String dni){
        Patient patientToProfileDelete = repository.findByDni(dni).orElse(null);
        Profile profileToDelete = patientToProfileDelete.getProfile();
        patientToProfileDelete.setProfile(null);
        profileRepository.delete(profileToDelete);
        return repository.findByDni(dni).orElse(null);
    }
}
