package com.techelevator.npgeek.model;

import java.util.List;

public interface WeatherForecastDao {
	
	public  List<WeatherForecast> getWeatherForcastByParkCode(String parkCode);
	
}
