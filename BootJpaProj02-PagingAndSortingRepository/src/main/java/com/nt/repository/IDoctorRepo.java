package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import com.nt.entity.Doctor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDoctorRepo extends CrudRepository<Doctor,Integer>, 
						PagingAndSortingRepository<Doctor,Integer> {

}
