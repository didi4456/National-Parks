package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDao {
	
	public List<Survey> getAllSurveys();
	public void save(Survey post);
	public Survey getFavoritePark();


}
