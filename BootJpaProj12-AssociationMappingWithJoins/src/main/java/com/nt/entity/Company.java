package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_COMAPNY_PARENT")
@Setter
@Getter
@RequiredArgsConstructor
public class Company {
	@Id
	@SequenceGenerator(name = "gen1", initialValue = 101, sequenceName = "company_seq", allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer cid;

	@NonNull
	@Column(length = 25)
	private String cname;
	@Column(length = 25)
	@NonNull
	private String addrs;

	@Column(length = 25)
	@NonNull
	private Integer pinCode;

	// in this we written mappedBy field so no need to write joincolumn annotation
	@OneToMany(targetEntity = TechnicalJob.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "company")
	private Set<TechnicalJob> openings;

	// toString
	@Override
	public String toString() {
		return "Company [cid=" + cid + ", cname=" + cname + ", addrs=" + addrs + ", pinCode=" + pinCode + "]";
	}

	// constructor
	public Company() {
		System.out.println("0:Param Constructor");
	}
}
