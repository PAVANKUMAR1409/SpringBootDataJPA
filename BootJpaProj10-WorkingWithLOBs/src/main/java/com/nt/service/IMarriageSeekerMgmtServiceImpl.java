package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.MarriageSeeker;
import com.nt.repository.IMarriageSeekerRepository;

@Service
public class IMarriageSeekerMgmtServiceImpl implements IMarriageSeekerMgmtService {

	@Autowired
	private IMarriageSeekerRepository repo;
	
	@Override
	public String savingLobs(MarriageSeeker profile) {
		int idVal=repo.save(profile).getId();
		return "Marriage Seeker is saved with id ::=>"+idVal;
	}

	@Override
	public Optional<MarriageSeeker> getLobs(int id) {
		
		return repo.findById(id);
	}

}
