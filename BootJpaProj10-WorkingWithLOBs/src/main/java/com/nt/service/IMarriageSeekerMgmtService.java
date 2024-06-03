package com.nt.service;

import java.util.Optional;

import com.nt.Entity.MarriageSeeker;

public interface IMarriageSeekerMgmtService {
	public String savingLobs(MarriageSeeker profile);
	public Optional<MarriageSeeker> getLobs(int id);
}
