package com.projet9.mediscreen.Repository;

import com.projet9.mediscreen.Domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends CrudRepository<Patient, Integer> {

    public Patient findByLastNameAndFirstName(String lastName, String firstName);
    public Patient findById(long id);
}
