package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service
public class DoctorMgmtServiceImpl implements IDoctorService
{
	@Autowired
	private IDoctorRepo repo;

	@Override
	public String removeDoctorsByIds(List<Integer> ids) {
		// check the availability of records
		Iterable<Doctor> it= repo.findAllById(ids);
		// get the count of records
		long count=((List<Doctor>)it).size();
		// delete the available records
		repo.deleteAllByIdInBatch(ids);
		return count+" no of records are deleted";
	}

	@Override
	public List<Doctor> searchDoctorsByExampleData(Doctor doc, boolean ascOrder, String... props) {
		// creating sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		// create Example Object
		Example<Doctor> example=Example.of(doc);
		// logics
		List<Doctor> list=repo.findAll(example, sort);
		return list;
	}

	@Override
	public Optional<Doctor> getDoctorById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public Doctor findDocById(int id) {
		
		return repo.getReferenceById(id);
	}

	
	
	
	
	
}
