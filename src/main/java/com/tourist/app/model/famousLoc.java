package com.tourist.app.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Locations")
@JsonIgnoreProperties({ "place" })
public class famousLoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locatid;
	private String locatName;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pinCode", nullable = false)
	private places place;

	public Integer getLocatid() {
		return locatid;
	}

	public void setLocatid(Integer locatid) {
		this.locatid = locatid;
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

	public places getPlace() {
		return place;
	}

	public void setPlace(places place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "famousLoc [locatid=" + locatid + ", locatName=" + locatName + ", description=" + description
				+ ", place=" + place + "]";
	}

}
