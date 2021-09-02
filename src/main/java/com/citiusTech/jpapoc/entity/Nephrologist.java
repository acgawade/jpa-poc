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
public class Nephrologist {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String specialization;

	private String mobileNumber;

	private String emailAddress;

	@ManyToMany
	@JsonIgnore
	private List<Facility> facilities;

	@OneToMany
	@JoinColumn(name = "nephrologist_id")
	@JsonIgnore
	private List<Patient> patients;
}
