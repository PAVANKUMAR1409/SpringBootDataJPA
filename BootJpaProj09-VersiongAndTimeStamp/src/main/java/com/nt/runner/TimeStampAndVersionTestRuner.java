package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.AirtelCallerTune;
import com.nt.service.ICallerTuneMgmtService;

@Component
public class TimeStampAndVersionTestRuner implements CommandLineRunner
{
	@Autowired
	private ICallerTuneMgmtService tuneService;

	@Override
	public void run(String... args) throws Exception {
		/*AirtelCallerTune tune= new AirtelCallerTune("Asha-Apsham", "C/O Kancherapalam", 9676436855L);
		String msg = tuneService.saveCallerTune(tune);
		System.out.println(msg);*/
		
		String updatedMsg=tuneService.updateTuneById(1, "sami", "Pushpa");
		System.out.println(updatedMsg);
		
	}
	
	
}
