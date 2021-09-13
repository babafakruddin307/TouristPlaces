package com.tourist.app.service.impl;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourist.app.model.famousLoc;
import com.tourist.app.repo.FamousLocRepository;
import com.tourist.app.service.FamousLocService;

@Service
public class FamousLocServiceImpl implements FamousLocService{
	@Autowired
	private FamousLocRepository repo;

	@Override
	public Integer saveFPlace(famousLoc f) throws IOException {
		f=repo.save(f);
		return f.getLocatid();
	}

	@Override
	public List<famousLoc> getAllFPlaces() {

		return repo.findAll();
	}

	@Override
	public void deleteFPlace(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public famousLoc getFPlaceById(Integer id) {
		return repo.findById(id).get();
	}

}
