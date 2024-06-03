package com.nt.service;

import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService 
{
	public String registerDoctor(Doctor doc);
	public boolean isDoctorAvailable(Integer id);
	public long fetchDoctorsCount();
	public Iterable<Doctor> showAllDoctors();
	public Iterable<Doctor> showAllDoctorsById(Iterable<Integer> id);
	public Optional<Doctor> getDoctorById(int id);
	public Doctor showDoctorById(Integer id);
	public Doctor fetchDoctorById(Integer id);
	
	public String registerOrUpdateDoctor(Doctor doc);
	public String updateDoctorIncome(Integer id,Double income);
}
