package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<Doctor> showDoctorsBySorting(boolean ascOrder, String... props) {
		// creating sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		//findAll(Sort)
		Iterable<Doctor> it=repo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize) {
		//creating pageable object
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		// creating Page Object
		Page<Doctor> page=repo.findAll(pageable);
		
		return page;
	}

	@Override
	public Page<Doctor> showSortedDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String... props) {
		// create sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		// create pageable object
		Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
		//create page object
		Page<Doctor> page =repo.findAll(pageable);
		return page;
	}

	@Override
	public void showDoctorsThroughPagination(int pageSize) {
		
		long count=repo.count();
		long pagesCount=count/pageSize;
		if(count%pagesCount!=0)
			pagesCount++;
		
		for(int i=0;i<pagesCount;i++) {
			// creating sort object
			Sort sort=Sort.by(Direction.ASC, "docName");
			//creating pageable object
			Pageable pagable=PageRequest.of(i, pageSize,sort);
			// get each page record
			Page<Doctor> page= repo.findAll(pagable);
			System.out.println("page :: "+(page.getNumber()+1)+" records of "+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("===========================================");
		}// end of for loop
	}
	
	
	
	
}
