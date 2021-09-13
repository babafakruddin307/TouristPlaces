package com.tourist.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "places")
public class places {
	@Id
	private Integer pinCode;
	private String placeName;
	private String state;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="place")
	private Set<famousLoc> Fplaces = new HashSet<famousLoc>();

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Set<famousLoc> getFplaces() {
		return Fplaces;
	}

	public void setFplaces(Set<famousLoc> fplaces) {
		Fplaces = fplaces;
	}

	@Override
	public String toString() {
		return "places [placeName=" + placeName + ", state=" + state + ", pinCode=" + pinCode + ", Fplaces=" + Fplaces
				+ "]";
	}
	

}
