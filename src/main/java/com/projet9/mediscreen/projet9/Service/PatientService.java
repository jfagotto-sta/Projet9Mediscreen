package com.projet9.mediscreen.projet9.Service;

import com.projet9.mediscreen.projet9.Domain.Patient;
import com.projet9.mediscreen.projet9.Repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    IPatientRepository iPatientRepository;


    public Patient newPatient(Patient patient) {
        return iPatientRepository.save(patient);
    }

    public Patient findById(int id){
        return iPatientRepository.findById(id);
    }

    public Boolean deletePatientById(int id){
        Patient patient = findById(id);
        iPatientRepository.delete(patient);
        return true;
    }

    public Iterable<Patient> findAllPatient(){
        return iPatientRepository.findAll();
    }

    public Patient updatePatient(Patient patient){
        return iPatientRepository.save(patient);
    }

    public Patient findByLastNameAndFirstName(String lastName, String firstName){
        return iPatientRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    public Patient updatePatientData(Patient patient){

        //Patient patientInDataBase = findById(patient.getId());

//        patientInDataBase.setLastName(patient.getLastName());
//        patientInDataBase.setFirstName(patient.getFirstName());
//        patientInDataBase.setBirthDate(patient.getBirthDate());
//        patientInDataBase.setAddress(patient.getAddress());
//        patientInDataBase.setGender(patient.getGender());

        return iPatientRepository.save(patient);

        //newPatient(patientInDataBase);

        //return patientInDataBase;
    }

}
