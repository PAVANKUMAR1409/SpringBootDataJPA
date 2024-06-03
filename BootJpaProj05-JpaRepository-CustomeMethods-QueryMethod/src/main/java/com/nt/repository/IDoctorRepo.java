package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;

import jakarta.transaction.Transactional;


public interface IDoctorRepo extends JpaRepository<Doctor, Integer>
{
	
	//@Query("FROM Doctor")
	//@Query("FROM com.nt.entity.Doctor")
	//@Query("FROM Doctor as doc")
	@Query("SELECT doc FROM Doctor doc")
	public List<Doctor> showAllDoctors();
	
	/*@Query("FROM Doctor WHERE income>=:min AND income<=:max")
	public List<Doctor> showAllDoctorsByIncomeRange(@Param("min")Double start, @Param("max")Double end);*/
	
	/*@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> showAllDoctorsByIncomeRange(@Param("start")Double start, @Param("end")Double end);*/
	
	/*@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> showAllDoctorsByIncomeRange(Double start, Double end);*/
	
	/* -------SELECTING MULTIPLE RECORDS-------------------*/
	@Query("FROM Doctor WHERE income>=?1 AND income<=?2")
	public List<Doctor> showAllDoctorsByIncomeRange(Double start, Double end);
	
	@Query("SELECT docId,docName,income FROM Doctor WHERE income BETWEEN :start AND :end")
	public List<Object[]> searchDoctorsDataByIncome(Double start,Double end);
	
	@Query("SELECT docName FROM Doctor WHERE income BETWEEN :start AND :end")
	public List<String> searchDoctorsNameDataByIncome(Double start,Double end);
	
	@Query("SELECT docName FROM Doctor WHERE docName LIKE :initChar")
	public List<String> searchDoctorsNameDataByName(String initChar);
	
	
	/* -------SELECTING SINGLE RECORDS-------------------*/
	@Query("FROM Doctor WHERE docName= :docName")
	public Optional<Doctor> searchDoctorByDocName(String docName);
	
	@Query("SELECT specialization FROM Doctor WHERE docName IN (:docName1,:docName2)")
	public Object[] searchDoctorsSpecializationsByDocName(String docName1,String docName2);
	
	@Query("SELECT specialization FROM Doctor WHERE docName=:docName")
	public String searchDoctorsSpecializationByDocName(String docName);
	
	@Query("SELECT count(*) FROM Doctor")
	public long getCountOfDoctors();
	
	@Query("SELECT count(income), max(income), min(income), avg(income), sum(income) FROM Doctor")
	public Object getAggregateDetails();
	
	//====================NON-SELECT QUERY=============================
	
	@Query("UPDATE Doctor SET income=income+(income*:percent/100) WHERE specialization=:job ")
	@Modifying
	@Transactional
	public int modifySalaryBySpecialization(String job, Double percent);
	
	
	@Query("DELETE FROM Doctor WHERE specialization=:job ")
	@Modifying
	@Transactional
	public int removeDoctorForSpecificJob(String job);
	
	//===========================NATIVE SQL QUERIES==============================
	
	@Query(value="SELECT sysdate FROM dual", nativeQuery=true)
	public String showSysdate();
	
	
	
	
}