package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JPA_JobSeeker_Info")
@Data
public class JobSeeker {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "doct_seq",
						initialValue=1000,allocationSize=1)
	@GeneratedValue(generator = "gen1",strategy =  GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="JS_ID")
	private Integer JsId;
	
	@Column(name="JS_NAME",length=25)
	private String JsName;
	
	@Column(name="JS_MOBILENO")
	private Long mobileNo;
	
	@Column(name="JS_QLFY")
	private String qlfy;
	
	@Column(name="JS_PERCENTAGE")
	private Double percentage;
	
	public JobSeeker() {
		System.out.println("0-Param Constructor :: "+this.getClass()+" Super class :: "+this.getClass().getSuperclass());
	}
	
}
