package com.techelevator.npgeek.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;



@Controller
public class SurveyController {

	private SurveyDao surveyDao;
	
	@Autowired 
	public SurveyController(SurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}
	
	@RequestMapping (path="/survey", method=RequestMethod.GET)
	public String showSurveyPage() {
		return "survey";
	}
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String processSurveyPost(Survey post) {
	surveyDao.save(post);
	
	return "redirect:/surveyResults";
}
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String showSurveyResult(ModelMap map) {
		
		Survey favPark = new Survey();
		favPark = surveyDao.getFavoritePark();
		map.put("favPark", favPark);
		return "surveyResults";
	}
}

