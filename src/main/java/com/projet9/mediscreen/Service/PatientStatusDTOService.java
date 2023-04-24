package com.projet9.mediscreen.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projet9.mediscreen.Domain.PatientStatusDto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Service;

@Service
public class PatientStatusDTOService {

    public PatientStatusDto getPatientStatus(long idPatient) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();

        PatientStatusDto response = client.target("http://localhost:8092/patient/status/" + idPatient)
                .request(MediaType.APPLICATION_JSON)
                .get(PatientStatusDto.class);

        return response;
    }
}
