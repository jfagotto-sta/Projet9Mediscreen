package com.projet9.mediscreen.projet9.Domain;

import java.util.Date;

public class Patient {

    private String firstName;
    private String lastName;
    private Date date;
    private String gender;
    private String phoneNumber;
    private String address;

    public Patient(String firstName, String lastName, Date date, String gender, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Patient() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
