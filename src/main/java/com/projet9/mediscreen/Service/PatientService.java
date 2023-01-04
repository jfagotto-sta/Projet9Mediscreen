package com.projet9.mediscreen.Service;

import com.projet9.mediscreen.Domain.Patient;
import com.projet9.mediscreen.Repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class PatientService {

    @Autowired
    IPatientRepository iPatientRepository;


  public Patient newPatient(Patient patient) {
        return iPatientRepository.save(patient);
    }

    public Patient findById(long id){
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
        return iPatientRepository.save(patient);

    }

//    public void deleteAll() {
//        iPatientRepository.deleteAll();
//    }
//
//    public Note findNoteForAPatient(int patientId) {
//      List<Note> completeList = findAllNotes();
//      Patient p = findById(patientId);
//        Note patientNote = new Note();
//        for (Note note: completeList ) {
//            if(note.getIdPatient()==p.getId()) {
//                patientNote.setIdNote(note.getIdNote());
//                patientNote.setMessage(note.getMessage());
//                patientNote.setMessageDate(note.getMessageDate());
//                patientNote.setIdPatient(p.getId());
//            }
//        }
//        return patientNote;
//    }
//
//    public List<Note> findAllNotes(){
//      return iNoteRepository.findAll();
//    }
}
