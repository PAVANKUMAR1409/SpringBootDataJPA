package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class JobSeekerMgmtImpl implements IJobSeekerMgmt{

	@Autowired
	private EntityManager manager;
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_JS_BY_PECENTAGE`(
			in min float,
		    in max float
		)
		BEGIN
			select * from jpa_jobseeker_info where js_percentage>=min
				and js_percentage<=max;
		END*/
	
	@Override
	public List<JobSeeker> showAllJSByPercentage(Double start, Double end) 
	{
		// create StoredProcedureQuery Object pointing PL_SQL Procedure
		StoredProcedureQuery query= manager.createStoredProcedureQuery("P_GET_JS_BY_PERCENTAGE",JobSeeker.class);
		// register both IN,OUT Parameters by specifying their mode
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		
		
		// set values into IN Parameters
		query.setParameter(1, start);
		query.setParameter(2, end);
		// call PL_SQL Procedure
		List<JobSeeker> list=query.getResultList();	
		return list;
	}

}
