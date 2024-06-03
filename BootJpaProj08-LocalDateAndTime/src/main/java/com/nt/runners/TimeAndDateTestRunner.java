package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Patient;
import com.nt.service.IPatientMgmtService;

@Component
public class TimeAndDateTestRunner implements CommandLineRunner {

	@Autowired
	private IPatientMgmtService service;
	
	@Override
	public void run(String... args) throws Exception
	{
		/*Patient patient=new Patient(0, "Surya", "Lungs", 
												LocalDate.of(2018,8,14), 
												LocalTime.of(15, 30),
												LocalDateTime.of(1996,9,13,8,30));
		String msg=service.registerPatient(patient);
		System.out.println(msg);*/
		
		/*Patient pat = service.getPatientById(1001);
		System.out.println(pat);*/
		
		System.out.println(service.getPatientAgeById(1001));
		
	}

}
