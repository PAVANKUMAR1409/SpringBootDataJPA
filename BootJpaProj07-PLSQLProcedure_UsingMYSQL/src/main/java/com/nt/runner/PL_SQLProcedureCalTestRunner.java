package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IJobSeekerMgmt;

@Component
public class PL_SQLProcedureCalTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmt service;
	
	@Override
	public void run(String... args) throws Exception {
		
		// invoke business method of service
		service.showAllJSByPercentage(60.3, 99.0).forEach(System.out::println);
	}
	
	
	
}
