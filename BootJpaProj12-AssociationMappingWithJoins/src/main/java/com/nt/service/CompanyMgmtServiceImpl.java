package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Company;
import com.nt.entity.TechnicalJob;
import com.nt.repository.ICompanyRepository;
import com.nt.repository.ITechnicalJobRepository;

@Service
public class CompanyMgmtServiceImpl implements ICompanyMgmtService {

	@Autowired
	private ICompanyRepository companyRepo;

	@Autowired
	private ITechnicalJobRepository techJobRepo;

	@Override
	public List<Object[]> fetchDataUsingJoinsByParent() {
		
		return companyRepo.fetchDataUsingJoinsByParent();
	}

	
}
