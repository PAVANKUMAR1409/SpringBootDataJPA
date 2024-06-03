package com.nt.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor@RequiredArgsConstructor
public class MarriageSeeker 
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private String name;
	
	@NonNull
	private Long mobileNo;
	
	@NonNull
	@Lob
	@Column(length=1000)
	private byte[] photo;
	
	@NonNull
	@Lob
	@Column(length=1000)
	private char[] resume;
}
