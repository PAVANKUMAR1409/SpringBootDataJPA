package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorService 
{
	public Iterable<Doctor> showDoctorsBySorting(boolean ascOrder, String... props);
	
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize);
	
	public Page<Doctor> showSortedDoctorsInfoByPageNo
					(int pageNo, int pageSize, boolean ascOrder,String...props);
	
	public void showDoctorsThroughPagination(int pageSize);
}
