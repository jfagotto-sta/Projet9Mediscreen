package com.projet9.mediscreen.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet9.mediscreen.Domain.NoteDTO;
import com.projet9.mediscreen.Domain.Patient;
import com.projet9.mediscreen.Domain.PatientStatusDto;
import com.projet9.mediscreen.Service.NoteDTOService;
import com.projet9.mediscreen.Service.PatientService;
import com.projet9.mediscreen.Service.PatientStatusDTOService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    NoteDTOService noteDTOService;

    @Autowired
    PatientStatusDTOService patientStatusDTOService;


    @GetMapping("/patient/list")
    @ResponseStatus(code = HttpStatus.OK)
    public String home(Model model) {
        Iterable<Patient> bidule = patientService.findAllPatient();
        model.addAttribute("patients", bidule);
        return "Patient/list";
    }

    @GetMapping("/note/delete/{id}/{idPatient}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteNote(@PathVariable("id") Long idNote, @PathVariable("idPatient") Long idPatient, Model model) {
        noteDTOService.deleteNote(idNote);
        Patient patient = patientService.findById(idPatient);
        List<NoteDTO> list = noteDTOService.getNotesForPatient(idPatient);
        model.addAttribute("patient", patient);
        patient.setNotes(list);
        return "Note/list";
    }

    @GetMapping(path = "/note/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String updateNote(@PathVariable("id") Long idNote, Model model) throws JsonProcessingException {
        NoteDTO note = noteDTOService.getNote(idNote);
        model.addAttribute("note", note);
        return "Note/update";
    }

    @PostMapping("/note/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String updateNote(@PathVariable("id") Long id, @Validated NoteDTO noteDTO,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Note/update";
        }

        try {
            NoteDTO n = noteDTOService.getNote(id);
            n.setMessage(noteDTO.getMessage());
            noteDTOService.updateNote(n);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        Patient patient = patientService.findById(id);
        List<NoteDTO> list = noteDTOService.getNotesForPatient(id);
        model.addAttribute("patient", patient);
        patient.setNotes(list);
        return "Note/list";
    }

    @PostMapping("/note/validate/{idPatient}")
    @ResponseStatus(code = HttpStatus.OK)
    public String newNote(@PathVariable("idPatient") Long id, @Validated NoteDTO noteDTO, Model model, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                noteDTO.setIdPatient(id);
                noteDTOService.newNote(noteDTO);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        Patient patient = patientService.findById(id);
        List<NoteDTO> list = noteDTOService.getNotesForPatient(id);
        model.addAttribute("patient", patient);
        patient.setNotes(list);
        return "Note/list";
    }

    @GetMapping("/note/add/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String addNote(@PathVariable("id") Long idPatient,NoteDTO note, Model model) {
        Patient patient = patientService.findById(idPatient);
        model.addAttribute("patient", patient);
        return "Note/add";
    }



    @GetMapping("/patient/notes/list/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public String patientNoteList(@PathVariable("id") Long id, Model model){
        Patient patient = patientService.findById(id);
        List<NoteDTO> list = noteDTOService.getNotesForPatient(id);
        model.addAttribute("patient",patient);
        patient.setNotes(list);
        return "Note/list";
    }

//    @GetMapping("/patient/note/liste")
//    @ResponseStatus(code=HttpStatus.OK)
//    public String patientWithNote(Model model){
//        List<PatientWithNote> patientWithNoteList = patientWithNoteDtoService.linkPatientWithHisNote();
//        model.addAttribute("patients",patientWithNoteList);
//        return "patient/list";
//    }

    @GetMapping("/patient/add")
    @ResponseStatus(code = HttpStatus.OK)
    public String addpatient(Patient patient) {
        return "patient/add";
    }


    @PostMapping("/patient/validate")
    @ResponseStatus(code = HttpStatus.OK)
    public String validate(@Validated Patient patient, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            patientService.newPatient(patient);
            model.addAttribute("patients", patientService.findAllPatient());
            return "redirect:/patient/liste";
        }
        return "patient/add";
    }

    @GetMapping("/patient/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientService.findById(id);
        model.addAttribute("patient", patient);
        return "patient/update";
    }

    @PostMapping("/patient/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String updateRating(@PathVariable("id") Long id, @Validated Patient patient,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "patient/update";
        }
        patient.setId(id);
        patientService.newPatient(patient);
        model.addAttribute("patients", patientService.findAllPatient());
        return "redirect:/patient/liste";
    }

    @GetMapping("/patient/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        patientService.deletePatientById(id);
        model.addAttribute("patients", patientService.findAllPatient());
        return "redirect:/patient/liste";
    }
}
