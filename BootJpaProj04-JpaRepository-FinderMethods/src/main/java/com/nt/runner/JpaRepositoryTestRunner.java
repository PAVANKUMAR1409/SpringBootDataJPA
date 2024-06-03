package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {
	
	@Autowired
	private IDoctorRepo repo;

	@Override
	public void run(String... args) throws Exception
	{
		/*repo.findByDocName("Pavan").forEach(System.out::println);
		repo.readByDocNameIs("Surya").forEach(System.out::println);
		repo.getByDocNameEquals("Radha").forEach(System.out::println);*/
		
		//repo.readBySpecializationContaining("un").forEach(System.out::println);
		/*repo.readBySpecializationStartingWith("l").forEach(System.out::println);
		System.out.println("==================================");
		repo.readBySpecializationStartingWithIgnoreCase("l").forEach(System.out::println);
		*/		
		
		/*repo.getBySpecializationLikeIgnoreCase("%e%").forEach(System.out::println);
		System.out.println("==================================");
		repo.getBySpecializationLikeIgnoreCase("_e%").forEach(System.out::println);*/
		
		repo.getBySpecializationInOrderByIncomeDesc(List.of("Lungs")).forEach(System.out::println);
		System.out.println("=======================================");
		repo.getBySpecializationInOrderByDocIdAsc(List.of("Lungs")).forEach(System.out::println);
	}
	
	
}
