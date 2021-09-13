package com.tourist.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourist.app.model.places;
import com.tourist.app.repo.PlaceReposiory;
import com.tourist.app.service.PlaceService;

@Service
public class placesServiceImpl implements PlaceService {

	@Autowired
	private PlaceReposiory repo;

	@Override
	public Integer savePlace(places p) {
		p=repo.save(p);
		return p.getPinCode();
	}

	@Override
	public List<places> getAllPlaces() {
		
		return repo.findAll();
	}

	@Override
	public void deletePlace(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public places getPlaceById(Integer id) {
		return repo.findById(id).get();
	}
	
	

}
