package com.projet9.mediscreen.projet9.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@AccessType(AccessType.Type.FIELD)
@Entity
@Table(appliesTo = "patient")
public class Patient implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    public Patient(int id, String firstName, String lastName, Date birthDate, String gender, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
}
