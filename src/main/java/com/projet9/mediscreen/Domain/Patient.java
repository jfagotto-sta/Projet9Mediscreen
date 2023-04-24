package com.projet9.mediscreen.Domain;

import com.projet9.mediscreen.Service.NoteDTOService;
import jakarta.persistence.*;
import org.springframework.data.annotation.AccessType;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AccessType(AccessType.Type.FIELD)
@Entity
@Table(name = "PATIENT")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "idPatient")
    private Long id;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Transient
    private List<NoteDTO> notes = new ArrayList<>();

    @Transient
    private PatientStatusDto patientStatusDto;

    @Transient
    private String patientStatus;


    public Patient(Long id, String firstName, String lastName, Date birthDate, String gender, String phoneNumber, String address, List<NoteDTO> notes, PatientStatusDto patientStatusDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.notes = notes;
        this.patientStatusDto = patientStatusDto;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }

    public PatientStatusDto getPatientStatusDto() {
        return patientStatusDto;
    }

    public void setPatientStatusDto(PatientStatusDto patientStatusDto) {
        this.patientStatusDto = patientStatusDto;
    }

    public String getPatientStatus() {
        return patientStatusDto==null?"":patientStatusDto.toString();
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }
}
