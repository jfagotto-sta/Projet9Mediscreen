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
@CrossOrigin(origins="http://localhost/8091")
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

}
