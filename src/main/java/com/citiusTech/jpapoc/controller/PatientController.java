package com.citiusTech.jpapoc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiusTech.jpapoc.entity.Facility;
import com.citiusTech.jpapoc.entity.Patient;
import com.citiusTech.jpapoc.repository.FacilityRepository;
import com.citiusTech.jpapoc.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PatientController {

	private final PatientRepository patientRepository;

	private final FacilityRepository facilityRepository;

	@GetMapping("/patient")
	public ResponseEntity<List<Patient>> getAllPatient() {
		List<Patient> resultList = patientRepository.findAll();
		ResponseEntity<List<Patient>> response = new ResponseEntity<List<Patient>>(resultList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/facility")
	public ResponseEntity<List<Facility>> getAllFacility() {
		List<Facility> resultList = facilityRepository.findAll();
		ResponseEntity<List<Facility>> response = new ResponseEntity<List<Facility>>(resultList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/facility/{id}")
	public ResponseEntity<Facility> getFacility(@PathVariable int id) {
		Optional<Facility> facilityOpt = facilityRepository.findById(id);
		if (facilityOpt.isPresent())
			return new ResponseEntity<Facility>(facilityOpt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Facility>(new Facility(), HttpStatus.NOT_FOUND);
	}

}
