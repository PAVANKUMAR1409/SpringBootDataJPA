package com.nt.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {
	
	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception
	{
		/*System.out.println(service.removeDoctorsByIds(Arrays.asList(1100,1004,1006,1007)));
		// Arrays.asList-> we can pass null -> no exception
		// List.of-> we can not pass null -> throws exception
		*/	
		/*Doctor doc=new Doctor();
		doc.setDocName("Pavan");doc.setIncome(50000.0);
		service.searchDoctorsByExampleData(doc, true, "specialization").forEach(System.out::println);;
		*/
		
		//Optional<Doctor> opt= service.getDoctorById(1002);
		/*if(opt.isPresent())
			System.out.println(" Record ::"+opt.get());
		else
			System.out.println("Record not found");*/
		
		
		/*	Doctor doc=service.findDocById(1004);
			System.out.println("Class name::"+doc.getClass());
			System.out.println("======================================");
			System.out.println("Doctor Name :: "+doc.getDocName()); // it hit the data base and generate the query
			//System.out.println("Doctor Id::"+doc.getDocId());// it won't hit the data base
		*/	
		try {
			Doctor doc=service.findDocById(1002);
			System.out.println("Record Found :: "+doc.toString());
		}catch(Exception e) {System.out.println("Record Not Found");}
	}
	
	
}
