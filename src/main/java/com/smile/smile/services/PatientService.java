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

    public void save(PatientPayload patientToAdd){
        // Aqui es donde usamos el PatientPayLoad para psar toda la info tanto del paciente como del profile
        // nuestro metodo save del controlador va a recibit un pay load con la informacion.
        // a continuación declaramos un nuevo profile donde vamos a poner la info correspondiente a la entidad
        // de profile 
        Profile patientProfile = new Profile(null
                                , patientToAdd.getProfile()
                                , patientToAdd.getPhone()
                                , patientToAdd.getAddress()
                                , patientToAdd.getCity());
        // despues llamamos al metodo del profileRepository, save para guardar nuestro nuevo perfil y asi asignar 
        // un numero de id que nos va a servir para crear al paciente
        Profile addedProfile =  profileRepository.save(patientProfile);
        // una vez tenemos el nuevo profile creamos el nuevo paciente y le asignamos el profile que creamos hace un momento

        Patient newPatient = new Patient(patientToAdd
                            .getDni()
                            , patientToAdd.getName()
                            , patientToAdd.getLastname()
                            , patientToAdd.getBirthdate()
                            , addedProfile);
        // una vez hecho esto simplemente llamamos al metodo save de nuestro repositorio de pacientes y añadimos a nuestro nuevo 
        // con su perfil ya asignado.
        repository.save(newPatient);
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
        return repository.findByDni(dni).map(patientPayload -> {

            patientPayload.setName(patient.getName());
                patientPayload.setLastname(patient.getLastname());
                patientPayload.setBirthdate(patient.getBirthdate());
                
            return repository.save(patientPayload);
        }).orElse(null);

        
    }
}
