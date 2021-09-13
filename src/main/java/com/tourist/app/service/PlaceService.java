package com.tourist.app.service;

import java.util.List;

import com.tourist.app.model.places;

public interface PlaceService {

	public Integer savePlace(places p);
	public List<places> getAllPlaces();
	public void deletePlace(Integer id);
	public places getPlaceById(Integer id);
}
