package com.nt.service;

import com.nt.Entity.AirtelCallerTune;

public interface ICallerTuneMgmtService 
{
	public String saveCallerTune(AirtelCallerTune tune);
	public String updateTuneById(Integer id, String tuneName, String movieName);
}
