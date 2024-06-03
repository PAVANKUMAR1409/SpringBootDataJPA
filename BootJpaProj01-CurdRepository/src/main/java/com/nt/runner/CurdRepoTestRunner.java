package com.nt.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
		/*try 
		{
			boolean flag=service.isDoctorAvailable(1);
			if(flag) 
				System.out.println("DOCTOR IS AVAILABLE");
			else
				System.out.println("Doctor is Not Available");	
			
		}catch(Exception e) {e.printStackTrace();}*/
		/*try {
			Doctor doc=new Doctor();
			doc.setDocName("Pavan");doc.setSpecialization("Leg");doc.setIncome(80000d);
			String res=service.registerDoctor(doc);
			System.out.println(res);
		}catch(Exception e) {e.printStackTrace();}*/
		
		/*try {
			Iterable<Doctor> list=service.showAllDoctors();
			list.forEach(System.out::println);  //Java 8 + Static method reference
			System.out.println("--------------------");
			list.forEach(doc->System.out.println(doc)); //java 8 feature
			System.out.println("---------------------");
			for(Doctor doc:list)
				System.out.println(doc);  //java 5 -enchanced for each loop
		}catch(Exception e) {e.printStackTrace();}*/
		/*try {
			Iterable<Doctor> it=service.showAllDoctorsById(List.of(1002,1152));
			it.forEach(System.out::println);
		}catch(Exception e) {e.printStackTrace();}*/
		
		/*try {
			System.out.println(service.fetchDoctorsCount());
		}catch(Exception e) {e.printStackTrace();}*/
		
		try {
			Optional<Doctor> opt=service.getDoctorById(1002);
			
				//Doctor doc=opt.get();
				Doctor doc=opt.orElseGet(()-> new Doctor());
				System.out.println(doc);
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		/*try {
			System.out.println(service.showDoctorById(1053));
		}catch(Exception e) {e.printStackTrace();}
		*/
		
		/*try {
			System.out.println(service.fetchDoctorById(1005));
		}catch(Exception e) {e.printStackTrace();}*/
		
		/*try {
			Doctor doctor=new Doctor();
			doctor.setDocId(1100);doctor.setDocName("Radha");doctor.setIncome(55000.0);doctor.setSpecialization("Liver");
			System.out.println(service.registerOrUpdateDoctor(doctor));
		}catch(Exception e) {e.printStackTrace();}*/
		
		/*try {
			String msg=service.updateDoctorIncome(1152, 45000.0);
			System.out.println(msg);
		}catch(Exception e) {e.printStackTrace();}*/
		
		
		
	}
}
