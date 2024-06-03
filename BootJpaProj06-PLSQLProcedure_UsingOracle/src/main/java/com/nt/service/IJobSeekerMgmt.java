package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeeker;

public interface IJobSeekerMgmt 
{
	public List<JobSeeker> showAllJSByPercentage(Double start,Double end);
}
