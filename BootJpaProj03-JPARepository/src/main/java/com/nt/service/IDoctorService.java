package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService 
{
	public String removeDoctorsByIds(List<Integer> ids);
	
	public List<Doctor> searchDoctorsByExampleData(Doctor doc,boolean ascOrder,String... props);
	
	public Optional<Doctor> getDoctorById(int id);
	
	public Doctor findDocById(int id);
}
