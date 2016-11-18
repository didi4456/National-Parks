package com.techelevator.npgeek.model;

public class WeatherForecast {
	
	private String parkCode;
	private int fiveDayForecast;
	private int lowTemp;
	private int highTemp;
	private String forecast;
	private String name;
	private String forecastRecommendation;
	private String tempRecommendation;
	private String tempDiffRecommendation;
	private String tempPref;
	
	public WeatherForecast(){
		
	}
	public String getParkCode() {
		return parkCode;
	}
	public String makeForecastRecommendation(String forecast) {
		if(forecast.equals("rain")) {
			forecastRecommendation = "Pack rain gear and wear waterproof shoes.";
		}else if(forecast.equals("snow")) {
			forecastRecommendation = "Pack snow shoes.";
		}else if(forecast.equals("thunderstorms")) {
			forecastRecommendation = "Seek shelter and avoid hiking on exposed ridges.";
		}else if(forecast.equals("sunny")) {
			forecastRecommendation = "Pack sun block.";
		}else if(forecast.equals("partly cloudy") || forecast.equals("cloudy")) {
			forecastRecommendation = "Enjoy the weather! Don't do anything stupid out there...";
		}
		return forecastRecommendation;
	}
	public String makeTempRecommendation(int highTemp, int lowTemp) {
		if(highTemp > 75) {
			tempRecommendation = "Bring an extra gallon of water";
		}else if(lowTemp < -20) {
			tempRecommendation = "WARNING!: Danger of exposure to frigid temperatures";
		}
		return tempRecommendation;
	}
	public String tempDiffRecommendation(int highTemp, int lowTemp) {
		if((highTemp - lowTemp) >= 20) {
			tempDiffRecommendation = "Wear breathable layers";
		}
		return tempDiffRecommendation;
	}
	public int getFiveDayForecast() {
		return fiveDayForecast;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public void setFiveDayForecast(int fiveDayForcast) {
		this.fiveDayForecast = fiveDayForcast;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForecastRecommendation() {
		return forecastRecommendation;
	}
	public String getTempRecommendation() {
		return tempRecommendation;
	}
	public String getTempDiffRecommendation() {
		return tempDiffRecommendation;
	}
	
//	public int getHighTempPreference(String ){
//	if (tempPreference.equals("celcius")){
//		highTemp=(highTemp-32) *(5/9);
//	}
//		return highTemp;
//	}
//	public int getLowTempPreference(int lowTemp){
//	if (tempPreference.equals("celcius")) {
//		lowTemp = (lowTemp - 32) * (5 / 9);
//	}
//		return lowTemp;
//	}
	public void setTempPref(String tempPref){
		this.tempPref = tempPref;
		if(tempPref.equalsIgnoreCase("celsius")) {
			lowTemp = (lowTemp - 32) * (5 / 9);
			highTemp = (highTemp - 32) * (5 / 9);
		}else if(tempPref.equalsIgnoreCase("farenheit")) {
			lowTemp = getLowTemp();
			highTemp = getHighTemp();
		}
	}
	
	public String getTempPref() {
		return tempPref;
	}
}
	

