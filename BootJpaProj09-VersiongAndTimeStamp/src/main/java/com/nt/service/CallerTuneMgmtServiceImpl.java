package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.AirtelCallerTune;
import com.nt.repository.IcallerTuneRepository;

@Service
public class CallerTuneMgmtServiceImpl implements ICallerTuneMgmtService {

	@Autowired
	private IcallerTuneRepository tuneRepo;
	@Override
	public String saveCallerTune(AirtelCallerTune tune) {
		int idVal=tuneRepo.save(tune).getTuneId();
		return "Caller tune is saved with Id value::=>"+idVal;
	}
	@Override
	public String updateTuneById(Integer id, String tuneName, String movieName) {
		Optional<AirtelCallerTune> opt = tuneRepo.findById(id);
		if(opt.isPresent()) {
			AirtelCallerTune tune = opt.get();
			tune.setTuneName(tuneName);tune.setMovieName(movieName);
			AirtelCallerTune tune2 = tuneRepo.save(tune);
			return "Object is update for "+tune2.getUpdatedCount()+" times... lastly modified on "+
					tune2.getUpdatedOn()+" and created on "+tune2.getCreatedOn();
			
		}
		return null;
	}

}
