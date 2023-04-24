package com.projet9.mediscreen.Controller;

import com.projet9.mediscreen.Domain.Patient;
import com.projet9.mediscreen.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PatientController {

    @Autowired
    PatientService patientService;


    @GetMapping("/patient/list")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Patient> home() {
        Iterable<Patient> patientList = patientService.findAllPatient();
        return patientList;
    }

    @GetMapping("/patient/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping("/patientSansStatus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Patient getPatientSansStatusById(@PathVariable Long id) {
        return patientService.findByIdSansStatus(id);
    }


    @PostMapping("/patient/add")
    @ResponseStatus(code = HttpStatus.OK)
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.newPatient(patient);
    }

    @DeleteMapping("/patient/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deletePatient(@PathVariable("id") Integer id) {
        patientService.deletePatientById(id);
    }

    @PutMapping("/patient/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void updatePatient(@RequestBody Patient patient) {

        Patient patientToUpdate = patientService.findById(patient.getId());

        patientToUpdate.setFirstName(patient.getFirstName());
        patientToUpdate.setLastName(patient.getLastName());
        patientToUpdate.setGender(patient.getGender());
        patientToUpdate.setAddress(patient.getAddress());
        patientToUpdate.setPhoneNumber(patient.getPhoneNumber());

        patientService.updatePatient(patientToUpdate);
    }
}
