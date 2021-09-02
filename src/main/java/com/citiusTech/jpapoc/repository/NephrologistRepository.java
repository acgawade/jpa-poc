package com.citiusTech.jpapoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiusTech.jpapoc.entity.Nephrologist;

@Repository
public interface NephrologistRepository extends JpaRepository<Nephrologist, Integer> {

}
