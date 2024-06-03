package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class CurdRepoTestRunner implements CommandLineRunner {
	
	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception
	{
		/*service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println("====================");
		service.showDoctorsBySorting(true, "docName","specialization").forEach(System.out::println);*/
		
		/*Page<Doctor> page=service.showDoctorsInfoByPageNo(0, 3);
		System.out.println("Page content ==>");
		List<Doctor> list=page.getContent();
		list.forEach(System.out::println);
		System.out.println("Page Number::"+page.getNumber());
		System.out.println("Page Count::"+page.getTotalPages());
		System.out.println("is it first page ::"+page.isFirst());
		System.out.println("is it last page :: "+page.isLast());
		System.out.println("Page Size ::"+page.getSize());
		System.out.println("Page elements count::"+page.getNumberOfElements());*/
		
		/*Page<Doctor> page=service.showSortedDoctorsInfoByPageNo(1, 3, true, "docName");
		page.getContent().forEach(System.out::println);
		*/	
		
		service.showDoctorsThroughPagination(3);
	}
	
	
}
