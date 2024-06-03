package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Patient 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "doct_seq",
							initialValue=1001,allocationSize=1)
	@GeneratedValue(generator = "gen1",strategy =  GenerationType.SEQUENCE)
	private Integer pId;
	
	@NonNull
	@Column(length=25)
	private String pName;
	
	@Column(length=25)
	@NonNull
	private String pDisease;
	
	@NonNull
	private LocalDate doj;
	@NonNull
	private LocalTime toj;
	@NonNull
	private LocalDateTime dob;
}
