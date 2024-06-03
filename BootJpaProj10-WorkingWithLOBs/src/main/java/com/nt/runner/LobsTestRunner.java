package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.MarriageSeeker;
import com.nt.service.IMarriageSeekerMgmtService;
@Component
public class LobsTestRunner implements CommandLineRunner {
	
	@Autowired
	private IMarriageSeekerMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*Scanner sc= new Scanner(System.in);
		System.out.println("Enter Name of Marriage:");
		String name=sc.next();
		System.out.println("Enter Mobile no:");
		Long num=sc.nextLong();
		
		System.out.println("Enter path of the photo");
		String photoPath=sc.next();
		// prepare byte[] representing photo file content
		FileInputStream fis= new FileInputStream(photoPath);
		byte[] photoData=new byte[fis.available()];
		photoData=fis.readAllBytes();
		fis.close();
		
		System.out.println("Enter path of resume:");
		String resumePath=sc.next();
		// preparing char[] representing resume file context
		File file = new File(resumePath);
		FileReader fr=new FileReader(file);
		char[] resumeContent=new char[(int)file.length()];
		fr.read(resumeContent);
		fr.close();
		
		// preparing entity class object
		MarriageSeeker info=new MarriageSeeker(name,num,photoData,resumeContent);
		
		String msg=service.savingLobs(info);
		System.out.println(msg);
		
		sc.close();*/
		
		
		Optional<MarriageSeeker> opt = service.getLobs(1);
		if(opt.isPresent()) {
			MarriageSeeker seeker = opt.get();
			System.out.println(seeker.getId()+"  "+seeker.getName()+"  "+seeker.getMobileNo() );
			
			//retrieve the photo file
			FileOutputStream fos=new FileOutputStream("retrieve_photo.jpg");
			fos.write(seeker.getPhoto());
			fos.flush();fos.close();
			
			//retrieve the resume file
			FileWriter fw= new FileWriter("retrieve_resume.txt");
			fw.write(seeker.getResume());
			fw.flush();fw.close();
			
			System.out.println(":::BLOB and CLOB are retrieved:::");
		}else {
			System.out.println("Id not fount");
		}
		
	}

}
