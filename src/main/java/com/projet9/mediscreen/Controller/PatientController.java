package com.projet9.mediscreen.Controller;

import com.projet9.mediscreen.Domain.Patient;
import com.projet9.mediscreen.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class PatientController {

    @Autowired
    PatientService patientService;


    @GetMapping("/patient/liste")
    @ResponseStatus(code=HttpStatus.OK)
    public String home(Model model){
        Iterable<Patient> bidule = patientService.findAllPatient();
        model.addAttribute("patients",bidule);
        return "patient/list";
    }

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
            return "redirect:/patient/list";
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
    public String updateRating(@PathVariable("id") Integer id, @Validated Patient patient,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "patient/update";
        }
        patient.setId(id);
        patientService.newPatient(patient);
        model.addAttribute("patients", patientService.findAllPatient());
        return "redirect:/patient/list";
    }

    @GetMapping("/patient/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        patientService.deletePatientById(id);
        model.addAttribute("patients", patientService.findAllPatient());
        return "redirect:/patient/list";
    }


 // --------------------------------
//    @GetMapping("/patient/{id}")
//    @ResponseStatus(code=HttpStatus.OK)
//    public Patient getPatientById(@PathVariable("id") Integer id){
//    return patientService.findById(id);
//    }
//
//
//    @GetMapping("/patient/{lastname}/{firstname}")
//    @ResponseStatus(code=HttpStatus.OK)
//    public Patient getPatientWithLastName(@PathVariable("lastname") String lastName, @PathVariable("firstname") String firstName){
//        return patientService.findByLastNameAndFirstName(lastName,firstName);
//    }
//
//    @PostMapping("/patient")
//    @ResponseStatus(code=HttpStatus.OK)
//    public Patient newPatient(@RequestBody Patient patient){
//        return patientService.newPatient(patient);
//    }
//
//    @PutMapping("/patient/update")
//    @ResponseStatus(code=HttpStatus.OK)
//    public Patient updatePatientWithId(@RequestBody Patient patient) {
//        return patientService.updatePatientData(patient);
//    }
//
//    @DeleteMapping("patient/delete/{id}")
//    @ResponseStatus(code=HttpStatus.OK)
//    public Boolean deletePatientWithId(@PathVariable("id") Integer id){
//        patientService.deletePatientById(id);
//        return true;
//    }
}
