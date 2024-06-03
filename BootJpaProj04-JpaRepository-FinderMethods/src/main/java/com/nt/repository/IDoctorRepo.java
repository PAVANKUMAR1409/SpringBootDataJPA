package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;


public interface IDoctorRepo extends JpaRepository<Doctor, Integer>{
	
	public List<Doctor> findByDocName(String name);
	public List<Doctor> readByDocNameIs(String name);
	public List<Doctor> getByDocNameEquals(String name); // All 3 are same 
	
	public Iterable<Doctor> readBySpecializationContaining(String chars);
	
	public Iterable<Doctor> readBySpecializationStartingWith(String initalChars);
	
	public Iterable<Doctor> readBySpecializationStartingWithIgnoreCase(String initalChars);
	
	public List<Doctor> getBySpecializationLikeIgnoreCase(String pattern);
	
	public List<Doctor> getBySpecializationInOrderByIncomeDesc(List<String> specializations);
	
	public List<Doctor> getBySpecializationInOrderByDocIdAsc(List<String> specializations);
	
	
	
	
	
}