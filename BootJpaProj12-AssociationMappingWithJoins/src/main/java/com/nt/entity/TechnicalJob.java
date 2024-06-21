package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_TECHNICALJOB_CHILD")
@Setter
@Getter
@RequiredArgsConstructor
public class TechnicalJob {

	@Id
	@SequenceGenerator(name = "jobGen", initialValue = 101, allocationSize = 1, sequenceName = "techJob_seq")
	@GeneratedValue(generator = "jobGen", strategy = GenerationType.SEQUENCE)
	private Integer jobId;

	@NonNull
	@Column(length = 30)
	private String jobName;

	@NonNull
	private Double salary;

	@NonNull
	private Integer experince;

	// if we write mappedBy field in manytoone annotation then no need to write
	// joincolumn annotation
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "TechJobId", referencedColumnName = "cid") // this is like foriegn key
	private Company company;

	// toString
	@Override
	public String toString() {
		return "TechnicalJob [jobId=" + jobId + ", jobName=" + jobName + ", salary=" + salary + ", experince="
				+ experince + "]";
	}

	// constructor
	public TechnicalJob() {
		System.out.println("0:Param Constructor");
	}

}
