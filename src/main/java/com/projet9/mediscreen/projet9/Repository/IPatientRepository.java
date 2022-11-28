package com.projet9.mediscreen.projet9.Repository;

import com.projet9.mediscreen.projet9.Domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface IPatientRepository extends CrudRepository<Patient, Integer> {

    public Patient findByLastNameAndFirstName(String lastName, String firstName);
    public Patient findById(int id);
}
