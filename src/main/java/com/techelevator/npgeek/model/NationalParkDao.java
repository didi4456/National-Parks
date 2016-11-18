package com.techelevator.npgeek.model;

import java.util.List;

public interface NationalParkDao {
	
	public List<NationalPark> getAllParks();
	
	public NationalPark getParkByParkCode(String parkCode);
	
}
