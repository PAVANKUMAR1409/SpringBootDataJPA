package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Patient;
import com.nt.repository.IPatientRepository;

@Service
public class PatientMgmtServiceImpl implements IPatientMgmtService {

	@Autowired
	private IPatientRepository repo;
	
	@Override
	public String registerPatient(Patient patient) {
		Patient pat=repo.save(patient);
		return "Patient information is saved with id value as ::=>"+pat.getPId();
	}

	@Override
	public Patient getPatientById(Integer id) {
		return repo.getReferenceById(id);
		
	}

	@Override
	public Double getPatientAgeById(Integer id) {
		return repo.getPatientAgeById(id);
		
	}

}
