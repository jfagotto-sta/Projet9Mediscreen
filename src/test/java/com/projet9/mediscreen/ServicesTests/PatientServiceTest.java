//package com.projet9.mediscreen.ServicesTests;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.projet9.mediscreen.Domain.NoteDTO;
//import com.projet9.mediscreen.Domain.Patient;
//import com.projet9.mediscreen.Domain.PatientStatusDto;
//import com.projet9.mediscreen.Service.NoteDTOService;
//import com.projet9.mediscreen.Service.PatientService;
//import com.projet9.mediscreen.Service.PatientStatusDTOService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
//
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class PatientServiceTest {
//
//    @Autowired
//    PatientService patientService;
//
//    @Mock
//    PatientStatusDTOService patientStatusDTOService;
//
//    @Mock
//    NoteDTOService noteDTOService;
//
//    @BeforeEach
//    public void beforAll(){
//        patientService.deleteAll();
//    }
//
//    @Test
//    public void test() throws JsonProcessingException {
//
//        // Test creation of a patient
//
//        PatientStatusDto patientStatusDto = new PatientStatusDto();
//        patientStatusDto.setBorderline(true);
//
//        List<NoteDTO> listNote = new ArrayList<>();
//
//        NoteDTO noteDTO = new NoteDTO();
//        noteDTO.setMessage("zzzzz");
//
//        listNote.add(noteDTO);
//
//        Patient patient = new Patient();
//        patient.setFirstName("aa");
//        patient.setLastName("bb");
//        patient.setAddress("ccc");
//        patient.setBirthDate(new Date());
//        patient.setPhoneNumber("0603");
//        patient.setGender("Male");
//        patientService.newPatient(patient);
//
//        when(patientStatusDTOService.getPatientStatus(patient.getId())).thenReturn(patientStatusDto);
//
//        when(noteDTOService.getNotesForPatient(patient.getId())).thenReturn(listNote);
//
//
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
