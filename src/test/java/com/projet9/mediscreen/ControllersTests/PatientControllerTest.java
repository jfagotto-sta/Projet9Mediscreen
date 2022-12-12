package com.projet9.mediscreen.ControllersTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet9.mediscreen.Domain.Patient;
import com.projet9.mediscreen.Service.PatientService;
import org.junit.jupiter.api.Test;


import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class PatientControllerTest {

    @MockBean
    public PatientService patientService;

    @MockBean
    private MockMvc mockMvc;


    @Test
    public void test() throws Exception {

        Patient patient = new Patient(1,"toto","titi",new Date(),"male","0606060606","29, rue moulin");

        Patient patient2 = new Patient(2,"olivier","giroud",new Date(),"male","0606060606","29, rue moulin");


    List<Patient> patientList = new ArrayList<>();
        patientList.add(patient);
        patientList.add(patient2);

    ObjectMapper mapper = new ObjectMapper();
    String t = mapper.writeValueAsString(patient);


    when(patientService.findAllPatient()).thenReturn(patientList);


        mockMvc.perform(get("/patient/liste"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("trades",containsInAnyOrder(patient,patient2)));

        mockMvc.perform(get("/patient/add"))
            .andExpect(status().isOk());

        mockMvc.perform(post("/patient/validate"))
            .andExpect(redirectedUrl("/patient/liste"));

        Mockito.doNothing().when(patientService).newPatient(patient);


        mockMvc.perform(post("/patient/validate").contentType(MediaType.APPLICATION_JSON).content(t))
            .andExpect(status().isOk())
            .andExpect(redirectedUrl("/patient/liste"));

    when(patientService.findById(anyInt())).thenReturn(patient);

        mockMvc.perform(get("/patient/update/{id}","4"))
            .andExpect(status().isOk());

        mockMvc.perform(post("/patient/update/{id}","4").
    content(t).contentType(MediaType.APPLICATION_JSON))
            .andExpect(redirectedUrl("/patient/liste"));


        mockMvc.perform(get("/patient/delete/{id}","4"))
            .andExpect(redirectedUrl("/patient/liste"));
}
}
