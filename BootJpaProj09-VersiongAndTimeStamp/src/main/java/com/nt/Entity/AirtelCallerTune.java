package com.nt.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data@NoArgsConstructor@RequiredArgsConstructor
public class AirtelCallerTune {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tuneId;
	
	@Column(length=25)@NonNull
	private String tuneName;
	
	@NonNull@Column(length=25)
	private String movieName;
	
	@NonNull
	private Long mobileNo;
	
	@Version
	private Integer updatedCount; //versioning feature
	@CreationTimestamp
	private LocalDateTime createdOn; // time stamping feature
	@UpdateTimestamp
	private LocalDateTime updatedOn; // time stamping feature
}
