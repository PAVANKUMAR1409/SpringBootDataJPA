package com.nt.service;

import com.nt.entity.Patient;

public interface IPatientMgmtService 
{
	public String registerPatient(Patient patient);
	public Patient getPatientById(Integer id);
	
	public Double getPatientAgeById(Integer id);
}
