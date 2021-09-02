package com.citiusTech.jpapoc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Patient {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String address;

	private String mobileNumber;

	private String emailAddress;

	@ManyToOne
	private Facility facility;

	@ManyToOne
	private Nephrologist nephrologist;

}
