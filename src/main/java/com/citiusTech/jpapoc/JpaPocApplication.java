package com.citiusTech.jpapoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.citiusTech.jpapoc.entity.Facility;
import com.citiusTech.jpapoc.entity.Nephrologist;
import com.citiusTech.jpapoc.entity.Patient;
import com.citiusTech.jpapoc.repository.FacilityRepository;
import com.citiusTech.jpapoc.repository.NephrologistRepository;
import com.citiusTech.jpapoc.repository.PatientRepository;

@SpringBootApplication
public class JpaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPocApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(FacilityRepository facilityRepository,
			PatientRepository patientRepository, NephrologistRepository nephrologistRepository) {
		return args -> {
			List<Facility> faclityList = new ArrayList<>();
			List<Nephrologist> nephrologistList = new ArrayList<>();
			IntStream.range(1, 5).forEach(i -> {
				Facility facilityToSave = Facility.builder().name("Facility Name-" + i).address("Facility Address-" + i)
						.contactNumber("916734880" + i).build();

				facilityToSave = facilityRepository.save(facilityToSave);
				faclityList.add(facilityToSave);
			});

			nephrologistList = List.of(
					Nephrologist.builder().name("John Doe").emailAddress("John.Doe@gmail.com").mobileNumber("916739786")
							.facilities(faclityList).specialization("MD. MBBS").build(),
					Nephrologist.builder().name("Achyut Gawade").emailAddress("gawade.achyut@gmail.com")
							.mobileNumber("9167348806").facilities(faclityList).specialization("MD. MTECH").build(),
					Nephrologist.builder().name("Prince Charles").emailAddress("Charles.Prince@gmail.com")
							.mobileNumber("9167344523").facilities(faclityList).specialization("MBBS").build(),
					Nephrologist.builder().name("Adofl Hitler").emailAddress("Hitler.nazi@gmail.com")
							.mobileNumber("9167340945").facilities(faclityList).specialization("MD. MR. MBA").build());
			nephrologistRepository.saveAll(nephrologistList);

			for (int i = 0; i < 15; i++) {
				Patient patientToSave = Patient.builder().name("Patient Name-" + i).address("Patient Address-" + i)
						.emailAddress("email" + i + "@gmail.com").mobileNumber("0225678654" + i)
						.facility(faclityList.get(new Random().nextInt(4)))
						.nephrologist(nephrologistList.get(new Random().nextInt(3))).build();
				patientRepository.save(patientToSave);
			}
		};
	};
}
