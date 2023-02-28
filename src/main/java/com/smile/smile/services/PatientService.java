package com.smile.smile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smile.smile.models.Patient;
import com.smile.smile.models.Profile;
import com.smile.smile.payloads.PatientPayload;
import com.smile.smile.repositories.PatientRepository;
import com.smile.smile.repositories.ProfileRepository;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientService {
    // Johnny estoy un poco mal y no puedo hablar mucho pero te explico lo de los payloads que nos quedó pendiente
    // En este servicio voy a instanciar el repositorio de perfil, aparte del repo de patient
    // Tenemos que preguntar si esto está bien o si es buena practica
    private PatientRepository repository;
    // etiqueta autowired para no hacer otro contructor por parametros para el profileRepository
    @Autowired
    private ProfileRepository profileRepository;

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
        //añadir un perfil a un paciente... pendiente
    }

    public List<Patient> delete(String dni){
        //aqui busco el paciente que voy a eliminar, primero me aseguro, debberíamos controlar que exista el 
        // perfil y el paciente para poder eliminarlo, sino nos salta un 500, en caso de que el paciente
        // a eliminar no tenga un profile anexo.
        Patient patientToDelete = repository.findByDni(dni).orElse(null);
        repository.delete(patientToDelete);
        profileRepository.delete(patientToDelete.getProfile());
        return repository.findAll();
    }

    public Patient update(String dni, PatientPayload patient){
        //creamos una funcion lambda para hacer el mapping de la parte del patient
        return repository.findByDni(dni).map(patientPayload -> {

            patientPayload.setName(patient.getName());
            patientPayload.setLastname(patient.getLastname());
            patientPayload.setBirthdate(patient.getBirthdate());

            Profile profileUpdate = patientPayload.getProfile();
            profileUpdate.setProfile(patient.getProfile());
            patientPayload.setProfile(profileUpdate);
            return repository.save(patientPayload);
        }).orElse(null);
    }
}
