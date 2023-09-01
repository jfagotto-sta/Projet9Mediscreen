package com.projet9.mediscreen.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projet9.mediscreen.Domain.NoteDTO;
import com.projet9.mediscreen.Domain.Patient;
import com.projet9.mediscreen.Domain.PatientStatusDto;
import com.projet9.mediscreen.Repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class PatientService {

    @Autowired
    IPatientRepository iPatientRepository;


    @Autowired
    PatientStatusDTOService patientStatusDTOService;

    @Autowired
    NoteDTOService noteDtoService;

  public Patient newPatient(Patient patient) {
        return iPatientRepository.save(patient);
    }

    public Patient findByIdSansStatus(long id){
        System.out.println("tata");
        Patient p =  iPatientRepository.findById(id);
        System.out.println("toto");
        p.setNotes(noteDtoService.getNotesForPatient(id));
        return p;

    }

    public Patient findById(long id){
        Patient p =  iPatientRepository.findById(id);
        p.setNotes(noteDtoService.getNotesForPatient(id));
        try {
            p.setPatientStatusDto(patientStatusDTOService.getPatientStatus(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return p;

    }

    public void deleteAll(){
      iPatientRepository.deleteAll();
    }

    public Boolean deletePatientById(int id){
        Patient patient = findById(id);
        iPatientRepository.delete(patient);
        return true;
    }

    public Iterable<Patient> findAllPatient(){
        Iterable<Patient> patients = iPatientRepository.findAll();
        for (Patient p :patients) {
            try {
                PatientStatusDto patientStatusDto = patientStatusDTOService.getPatientStatus(p.getId());
                List<NoteDTO> notes = noteDtoService.getNotesForPatient(p.getId());
                p.setPatientStatusDto(patientStatusDto);
                p.setNotes(notes);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return patients;
    }



    public Patient updatePatient(Patient patient){
        return iPatientRepository.save(patient);
    }

    public Patient findByLastNameAndFirstName(String lastName, String firstName){
        return iPatientRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    public Patient updatePatientData(Patient patient){
        return iPatientRepository.save(patient);

    }

}
