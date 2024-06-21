package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Company;
import com.nt.entity.TechnicalJob;
import com.nt.repository.ICompanyRepository;
import com.nt.repository.ITechnicalJobRepository;

@Service
public class CompanyMgmtServiceImpl implements ICompanyMgmtService {

	@Autowired
	private ICompanyRepository companyRepo;

	@Autowired
	private ITechnicalJobRepository techJobRepo;

	@Override
	public String saveParentToChild() {
		// company object
		Company company = new Company("WIPRO", "HYD", 500035);

		// job objects
		TechnicalJob job1 = new TechnicalJob("SpringDevloper", 60000.0, 1);
		TechnicalJob job2 = new TechnicalJob("AdvJavaDevloper", 80000.0, 2);

		// set child to parent
		company.setOpenings(Set.of(job1, job2));

		// set parent to child
		job1.setCompany(company);
		job2.setCompany(company);

		// save the parent object
		companyRepo.save(company);
		return " Parent and his child Objects are saved";
	}

	@Override
	public String saveDataThroughChild() {
		// company object
		Company company = new Company("INFOSYS", "DELHI", 100035);

		// job objects
		TechnicalJob job1 = new TechnicalJob("ReactDeveloper", 40000.0, 3);
		TechnicalJob job2 = new TechnicalJob("MongoDBDevloper", 60000.0, 4);

		// set child to parent
		company.setOpenings(Set.of(job1, job2));

		// set parent to child
		job1.setCompany(company);
		job2.setCompany(company);

		// save the child object
		techJobRepo.save(job1);
		techJobRepo.save(job2);
		return " Child and their Parent objects are saved";

	}

	@Override // fecthing one to many association
	public void loadDataUsingParent() {
		Iterable<Company> it = companyRepo.findAll();
		it.forEach(company -> {
			System.out.println(company);
			Set<TechnicalJob> childs = company.getOpenings();
			/*System.out.println("child size::=>" + childs.size());
			childs.forEach(tj -> {
				System.out.println("TechnicalJob::=>" + tj.getJobName());
			});*/

			/*if fetch type is LAZY then parent objects are loaded and childl objects are 
			not loaded.
			If fetch type is EAGER then when parent objects are loaded 
			then child objects are loaded*/

		});

	}

	@Override // fetching many to one association
	public void loadDataUsingChild() {
		List<TechnicalJob> list = techJobRepo.findAll();
		list.forEach(job -> {
			System.out.println("child::=>" + job);
			// get associated parent objects
			Company company = job.getCompany();
			System.out.println("Parent::=>" + company);
			System.out.println("-------------------------------");
		});

		/*
		 * For many to one association the fetch type is by default EAGER loading
		 * For one to many association the fetch type is by deafult LAZY loading*/
	}

	@Override
	public String deleteDataUsingParent(Integer parentId) {
		// Load parent Object
		Optional<Company> opt = companyRepo.findById(parentId);
		if (opt.isPresent()) {
			companyRepo.delete(opt.get());
			return "Parent and its associated child objects are deleted";

		}
		return "Parent Id not found for deletion";
	}

	@Override
	public String deleteDataUsingChild(Integer childId) {
		// Load Child Object
		Optional<TechnicalJob> job1 = techJobRepo.findById(childId);
		if (job1.isPresent()) {
			techJobRepo.delete(job1.get());
			return "Child and its associated parent are deleted";

		}
		return "Child Id is not found for deletion";

	}

	@Override
	public String deleteAllTechJobFromCompany(Integer companyId) {
		// Load parent object
		Optional<Company> opt = companyRepo.findById(companyId);
		if(opt.isPresent()) {
			// get child objects
			Set<TechnicalJob> job = opt.get().getOpenings();
			// delete all childs
			job.forEach(job1->{
				job1.setCompany(null);
			});
			techJobRepo.deleteAll(job);   //or techJobRepo.deleteAllInBatch(Job);
			return job.size()+" jobs of "+companyId+" company are deleted"; 
		}
		return companyId+" company not found";
	}

	@Override
	public void addNewChildToAParentById(Integer companyId) {
		// Load Parent Object
		Optional<Company> opt = companyRepo.findById(companyId);
		if(opt.isPresent()) {
			Company company = opt.get();
			
			// get childs of a parent
			Set<TechnicalJob> openings = company.getOpenings();
			
			// create a new child object
			TechnicalJob newJob = new TechnicalJob("Tester",45000.0,3);
			
			// link child to parent
			newJob.setCompany(company);
			openings.add(newJob);
			
			// save the object
			companyRepo.save(company);
			
			System.out.println("New Child is added to the existing childs of a parent");
			
		}//if
		else {
			System.out.println(companyId+" is not found");
		}
	}

}
