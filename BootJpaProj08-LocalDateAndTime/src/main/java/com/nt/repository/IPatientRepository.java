package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {

	@Query(value="SELECT datediff(now(),dob)/365.25 FROM Patient WHERE p_id=:id", nativeQuery=true)
	public Double getPatientAgeById(Integer id);
}
