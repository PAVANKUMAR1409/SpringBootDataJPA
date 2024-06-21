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
		/*String msg = service.saveParentToChild();
		System.out.println(msg);
		
		
		System.out.println(service.saveDataThroughChild());*/
		
		//service.loadDataUsingParent();
		
		//service.loadDataUsingChild();
		
		/*String deleteDataUsingParent = service.deleteDataUsingParent(101);
		System.out.println(deleteDataUsingParent);*/
		
		/*String deleteDataUsingChild = service.deleteDataUsingChild(103);
		System.out.println(deleteDataUsingChild);*/
		
		/*String msg = service.deleteAllTechJobFromCompany(124);
		System.out.println(msg);*/
		
		service.addNewChildToAParentById(123);
	}

}
