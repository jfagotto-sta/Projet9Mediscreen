package com.projet9.mediscreen.projet9.Controller;

import com.projet9.mediscreen.projet9.Domain.Patient;
import com.projet9.mediscreen.projet9.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patient/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public Patient getPatientById(@PathVariable("id") Integer id){
    return patientService.findById(id);
    }

    @GetMapping("patient/list")
    @ResponseStatus(code=HttpStatus.OK)
    public Iterable<Patient> getPatientList(){
        return patientService.findAllPatient();
    }

    @GetMapping("/patient/{lastname}/{firstname}")
    @ResponseStatus(code=HttpStatus.OK)
    public Patient getPatientWithLastName(@PathVariable("lastname") String lastName, @PathVariable("firstname") String firstName){
        return patientService.findByLastNameAndFirstName(lastName,firstName);
    }

    @PostMapping("/patient")
    @ResponseStatus(code=HttpStatus.OK)
    public Patient newPatient(@RequestBody Patient patient){
        return patientService.newPatient(patient);
    }

    @PutMapping("/patient/update")
    @ResponseStatus(code=HttpStatus.OK)
    public Patient updatePatientWithId(@RequestBody Patient patient) {
        return patientService.updatePatientData(patient);
    }

    @DeleteMapping("patient/delete/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public Boolean deletePatientWithId(@PathVariable("id") Integer id){
        patientService.deletePatientById(id);
        return true;
    }
}
