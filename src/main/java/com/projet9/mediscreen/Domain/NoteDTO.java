package com.projet9.mediscreen.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NoteDTO {

    private long idNote;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date messageDate;
    private long idPatient;

    private String message;


    public NoteDTO() {

    }
     public NoteDTO(long idNote, Date messageDate, long idPatient, String message) {
            this.idNote = idNote;
            this.messageDate = messageDate;
            this.idPatient = idPatient;
            this.message = message;
        }

        public long getIdNote() {
            return idNote;
        }

        public void setIdNote(long idNote) {
            this.idNote = idNote;
        }

        public Date getMessageDate() {
            return messageDate;
        }

        public void setMessageDate(Date messageDate) {
            this.messageDate = messageDate;
        }

        public long getIdPatient() {
            return idPatient;
        }

        public void setIdPatient(long idPatient) {
            this.idPatient = idPatient;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
