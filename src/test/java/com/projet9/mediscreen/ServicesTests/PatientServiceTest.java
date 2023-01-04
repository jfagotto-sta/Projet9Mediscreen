//package com.projet9.mediscreen.ServicesTests;
//
//import com.projet9.mediscreen.Domain.Patient;
//import com.projet9.mediscreen.Service.PatientService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class PatientServiceTest {
//
//    @Autowired
//    PatientService patientService;
//
//    @BeforeEach
//    public void beforAll(){
//        patientService.deleteAll();
//    }
//
//    @Test
//    public void test(){
//
//        // Test creation of a patient
//
//        Patient patient = new Patient(1,"toto","titi",new Date(),"male","0606060606","29, rue moulin", note);
//        patientService.newPatient(patient);
//        Patient patient1 = patientService.findById(patient.getId());
//        assertNotNull(patient1);
//
//        // Test update of a patient
//        patient.setFirstName("Giroud");
//        patientService.updatePatient(patient);
//        Patient patientAfterUpdate = patientService.findById(1);
//        assertTrue(patientAfterUpdate.getFirstName().equals("Giroud"));
//
//        // Find All
//        List<Patient> patientIterable = (List<Patient>) patientService.findAllPatient();
//        assertTrue(patientIterable.size() == 1);
//
//        // Delete Patient
//        patientService.deletePatientById(1);
//        List<Patient> listAfterDelete = (List<Patient>) patientService.findAllPatient();
//        assertTrue(patientIterable.size() == 0);
//
//    }
//}
