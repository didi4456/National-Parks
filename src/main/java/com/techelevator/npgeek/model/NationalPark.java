package com.techelevator.npgeek.model;

public class NationalPark {
	
	private String name; 
	private String location;
	private String summary;
	private String parkCode;
	private int acreage;
	private int elevationInFeet;
	private double milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitors;
	private String inspirationalQuote;
	private String quoteSource;
	private int entryFee;
	private int numberOfAnimalSpecies;
	
	public NationalPark() {
		
	}
	
	public NationalPark(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getParkCode() {
		return parkCode;
	}

	public int getAcreage() {
		return acreage;
	}

	public int getElevationInFeet() {
		return elevationInFeet;
	}

	public double getMilesOfTrail() {
		return milesOfTrail;
	}

	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}

	public String getClimate() {
		return climate;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public int getAnnualVisitors() {
		return annualVisitors;
	}

	public String getInspirationalQuote() {
		return inspirationalQuote;
	}

	public String getQuoteSource() {
		return quoteSource;
	}

	public int getEntryFee() {
		return entryFee;
	}

	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}

	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}

	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	public void setAnnualVisitors(int annualVisitors) {
		this.annualVisitors = annualVisitors;
	}

	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}

	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}

	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}

	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	
}
