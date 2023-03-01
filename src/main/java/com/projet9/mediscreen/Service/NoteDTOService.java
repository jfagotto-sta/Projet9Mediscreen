package com.projet9.mediscreen.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.projet9.mediscreen.Domain.NoteDTO;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

import java.util.List;

import com.google.gson.reflect.TypeToken;

@Service
public class NoteDTOService {

    public List<NoteDTO> getNotesForPatient(long idPatient){


        Client client = ClientBuilder.newClient();

        String response = client.target("http://localhost:8091/notes/patient/"+idPatient)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);


        Gson gson = new Gson();
        Type listType = new TypeToken<List<NoteDTO>>(){}.getType();
        List<NoteDTO> items = gson.fromJson(response, listType);

        return items;
    }
    public void deleteNote(long idNote){

        Client client = ClientBuilder.newClient();

        WebTarget resource = client.target("http://localhost:8091/delete/note/"+idNote);
        resource.request().delete(Long.class);
    }

    public void updateNote(NoteDTO noteDTO) throws JsonProcessingException {

        Client client = ClientBuilder.newClient();

//        Gson gson = new Gson();
//
//        gson.toJson(noteDTO);

        WebTarget resource = client.target("http://localhost:8091/note/update");
        resource.request()
                .accept(MediaType.APPLICATION_JSON)
                .put(Entity.json(noteDTO), NoteDTO.class);
    }

    public NoteDTO getNote(long idNote) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();

        NoteDTO response = client.target("http://localhost:8091/note/" + idNote)
                .request(MediaType.APPLICATION_JSON)
                .get(NoteDTO.class);



        return response;
    }

    public void newNote(NoteDTO noteDTO) throws JsonProcessingException {

        Client client = ClientBuilder.newClient();


        WebTarget resource = client.target("http://localhost:8091/note");
        resource.request()
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(noteDTO), NoteDTO.class);
    }
}

