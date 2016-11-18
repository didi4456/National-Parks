package com.techelevator.npgeek.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.NationalPark;
import com.techelevator.npgeek.model.NationalParkDao;
import com.techelevator.npgeek.model.WeatherForecast;
import com.techelevator.npgeek.model.WeatherForecastDao;

@SessionAttributes("preference")
@Controller
public class HomeController {
	
	private NationalParkDao parkDao;
	private WeatherForecastDao forecastDao;
	
	@Autowired
	public HomeController(NationalParkDao parkDao, WeatherForecastDao forecastDao) {
		this.parkDao = parkDao;
		this.forecastDao = forecastDao;
	}
	
	@RequestMapping(path="/home", method=RequestMethod.GET) 
		public String showNationalParkHomePage(ModelMap map) {
		
		List<NationalPark> nationalParkList = new ArrayList<>();
		nationalParkList = parkDao.getAllParks();
		map.put("nationalParkList", nationalParkList);
		return "home";	
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetails(@RequestParam String parkCode, ModelMap map){

		NationalPark park= parkDao.getParkByParkCode(parkCode);
		
		map.put("park", park);
		return "parkDetail";
	}
	
	@RequestMapping(path="/weatherForecast", method=RequestMethod.GET)
	public String displayWeatherForecast(@RequestParam String parkCode, ModelMap map) {

		List<WeatherForecast> forecast = new ArrayList<>();
		forecast = forecastDao.getWeatherForcastByParkCode(parkCode);
		
		NationalPark name = new NationalPark();
		name = parkDao.getParkByParkCode(parkCode);
		
		map.put("forecast", forecast);
		map.put("park", name);
		return "weatherForecast";
	}
	
	@RequestMapping(path="/weatherForecast", method=RequestMethod.POST)
	public String displayWeatherWithPreferences(@RequestParam String parkCode, @RequestParam String tempPref, ModelMap map) {
		
		List<WeatherForecast> forecast = new ArrayList<>();
		forecast = forecastDao.getWeatherForcastByParkCode(parkCode);
		
		WeatherForecast preference = new WeatherForecast();
		preference.setTempPref(tempPref);
		
		map.put("forecast", forecast);
		map.put("preference", preference);
		map.put("parkCode", parkCode);
		return "redirect:/weatherForecast";
	}

}
