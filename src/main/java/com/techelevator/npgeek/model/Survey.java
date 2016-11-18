package com.techelevator.npgeek.model;

public class Survey {
	private String emailAddress;
	private String stateOfResidence;
	private String physicalActivityLevel;
	private Long id;
	private String parkName;
	private String parkCode;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getStateOfResidence() {
		return stateOfResidence;
	}
	public String getPhysicalActivityLevel() {
		return physicalActivityLevel;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setStateOfResidence(String stateOfResidence) {
		this.stateOfResidence = stateOfResidence;
	}
	public void setPhysicalActivityLevel(String physicalActivityLevel) {
		this.physicalActivityLevel = physicalActivityLevel;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

}
