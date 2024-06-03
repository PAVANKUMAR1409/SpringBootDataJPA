package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JPA_Doctor_Info")
@Data
public class Doctor {
	@Id
	/*@SequenceGenerator(name="gen1",sequenceName = "doct_seq",
						initialValue=1000,allocationSize=1)
	@GeneratedValue(generator = "gen1",strategy =  GenerationType.SEQUENCE)*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DOC_ID")
	private Integer docId;
	@Column(name="DOC_NAME",length=25)
	private String docName;
	@Column(name="SPECIALIZATION",length=20)
	private String specialization;
	@Column(name="INCOME")
	private Double income;
	
	public Doctor() {
		System.out.println("0-Param Constructor :: "+this.getClass()+" Super class :: "+this.getClass().getSuperclass());
	}
	
}
