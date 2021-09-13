package com.tourist.app.dto;

public class FLocationDataRequest {

	private Integer pinCode;
	private String locatName;
	private String description;

	

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getLocatName() {
		return locatName;
	}

	public void setLocatName(String locatName) {
		this.locatName = locatName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
