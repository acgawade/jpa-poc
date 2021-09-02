package com.citiusTech.jpapoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiusTech.jpapoc.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
