package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service
public class DoctorMgmtServiceImpl implements IDoctorService
{
	@Autowired
	private IDoctorRepo repo;
	
	@Override
	public String registerDoctor(Doctor doc) {
		//System.out.println("Doctor Object Class Name=>In memory proxy class name====>"+repo.getClass());
		//System.out.println("DoctorMgmtServiceImpl.registerDoctor()");
		System.out.println("doctor id before save ::"+doc.getDocId());
		Doctor doctor=repo.save(doc);
		return "Doctor Object is saved with Id:: "+doctor.getDocId();
	}
	
	@Override
	public boolean isDoctorAvailable(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public Iterable<Doctor> showAllDoctorsById(Iterable<Integer> id) {
		
		return repo.findAllById(id);
	}
	
	

	@Override
	public Iterable<Doctor> showAllDoctors() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Doctor> getDoctorById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public long fetchDoctorsCount() {
		
		return repo.count();
	}

	@Override
	public Doctor showDoctorById(Integer id) {
		Doctor dutyDoctor=new Doctor();
		dutyDoctor.setSpecialization("Duty Doctor");
		Doctor doctor=repo.findById(id).orElse(dutyDoctor);
		return doctor;
	}

	@Override
	public Doctor fetchDoctorById(Integer id) {
		Doctor doctor=repo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Doctor Id"));
		return doctor;
	}

	@Override
	public String registerOrUpdateDoctor(Doctor doc) {
		Optional<Doctor> opt= repo.findById(doc.getDocId());
		if(opt.isPresent()) {
			repo.save(doc);  // for update the Object operation
			return doc.getDocId()+" Doctor details are found and Updated";
		}
		else {
			return "Doctor is saved with Id value "+repo.save(doc).getDocId();
		}
	}

	@Override
	public String updateDoctorIncome(Integer id, Double income) {
		Optional<Doctor> opt=repo.findById(id);
		if(opt.isPresent()) {
			Doctor doc=opt.get();
			doc.setIncome(income);
			repo.save(doc);
			return id+" doctor income is update";
		}
		return id+" is not found for updation";
	}
	
	
	
}
