package com.nt.runner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	
	@Autowired
	private IDoctorRepo repo;

	@Override
	public void run(String... args) throws Exception
	{
		/*	List<Doctor> list=repo.showAllDoctors();
			list.forEach(System.out::println);*/
		
		
		/*List<Doctor> list=repo.showAllDoctorsByIncomeRange(40000.0, 50000.0);
		list.forEach(System.out::println);*/
		
		/*System.out.println("==============Entity Scalar projection query with specific column values=============");
		repo.searchDoctorsDataByIncome(40000.0, 60000.0).forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+" ");
			}
			System.out.println();
		});*/
		
		
		/*System.out.println("==============Entity Scalar projection query with One column values=============");
		repo.searchDoctorsNameDataByIncome(40000.0, 60000.0).stream()
				.sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);*/
		
		/*repo.searchDoctorsNameDataByName("P%").forEach(System.out::println);*/
		
		/*Optional<Doctor> doc=repo.searchDoctorByDocName("Surya");
		System.out.println(doc.get());*/
		
		/*Object[] obj=repo.searchDoctorsSpecializationsByDocName("Surya","Radha");
		System.out.println(Arrays.toString(obj));*/
		
		//System.out.println(repo.searchDoctorsSpecializationByDocName("Surya"));
		
		
		/*System.out.println("Count of Doctors :: "+repo.getCountOfDoctors());
		System.out.println("--------------------------------------");
		Object[] data = (Object[])repo.getAggregateDetails();
		System.out.println("Aggreagte Details are :"+Arrays.toString(data));
		System.out.println("count="+data[0]+"\nmax of income="+data[1]+"\nmin of income="+data[2]+
				
				"\navg of income="+data[3]+"\nsum of income="+data[4]);	*/
		
		/*int k=repo.modifySalaryBySpecialization("Lungs", 20.0);
		System.out.println("No of Doctors that are usefull are::=>"+k);*/
		
		//System.out.println("Deleted no of Doctors are ::=>"+repo.removeDoctorForSpecificJob("Lungs"));
	
		System.out.println("system date is ::=>"+repo.showSysdate());
	}
	
	
}
