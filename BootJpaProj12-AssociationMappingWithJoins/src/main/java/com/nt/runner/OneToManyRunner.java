package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICompanyMgmtService;

@Component
public class OneToManyRunner implements CommandLineRunner{

	@Autowired
	private ICompanyMgmtService service;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		service.fetchDataUsingJoinsByParent().forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
	}// run

}// class
