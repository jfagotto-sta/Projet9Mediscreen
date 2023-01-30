package com.projet9.mediscreen.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projet9.mediscreen.Domain.NoteDTO;
import com.projet9.mediscreen.Domain.Patient;
import com.projet9.mediscreen.Domain.PatientStatusDto;
import com.projet9.mediscreen.Service.NoteDTOService;
import com.projet9.mediscreen.Service.PatientService;
import com.projet9.mediscreen.Service.PatientStatusDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.List;

@RestController
public class PatientRestController {

    @Autowired
    PatientService patientService;

    @Autowired
    NoteDTOService noteDTOService;

    @Autowired
    PatientStatusDTOService patientStatusDTOService;

    @GetMapping("/notes/patient")
    @ResponseStatus(code = HttpStatus.OK)
    public Patient getPatientById(@RequestParam long id) throws IOException {
        Patient patient = patientService.findById(id);
        List<NoteDTO> list = noteDTOService.getNotesForPatient(id);
        patient.setNotes(list);
        return patient;
    }

    @GetMapping("/patient/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

//o


//    @GetMapping("/note/list/patient")
//    @ResponseStatus(code = HttpStatus.OK)
//    public List<NoteDTO> getListOfNotesForPatient(@RequestParam long id, Model model) throws IOException {
//        List<NoteDTO> noteDTOList = noteDTOService.listOfNoteForAPatient(id);
//        return noteDTOList;
//    }

//    @PutMapping("/note/update/patient")
//    @ResponseStatus(code = HttpStatus.OK)
//    public NoteDTO updatePatientNote(@RequestBody NoteDTO noteDTO) {
//        noteDTOService.updateNote(noteDTO);
//        return noteDTO;
//    }
}
