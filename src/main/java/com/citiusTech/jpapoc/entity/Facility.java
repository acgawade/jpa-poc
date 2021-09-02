package com.citiusTech.jpapoc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Facility {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String address;

	private String contactNumber;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "facility_id")
	private List<Patient> Patients;

	@ManyToMany(mappedBy = "facilities")
	private List<Nephrologist> nephrologists;

}
