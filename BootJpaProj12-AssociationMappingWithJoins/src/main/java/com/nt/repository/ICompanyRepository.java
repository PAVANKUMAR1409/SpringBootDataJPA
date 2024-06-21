package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Company;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {

	@Query("SELECT c.cid, c.cname, c.addrs, c.pinCode, j.jobId, j.jobName, j.salary, j.experince FROM Company c INNER JOIN c.openings j")
	public List<Object[]> fetchDataUsingJoinsByParent();
}
