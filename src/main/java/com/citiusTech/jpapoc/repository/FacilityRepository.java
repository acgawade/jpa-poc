package com.citiusTech.jpapoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiusTech.jpapoc.entity.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {

}
