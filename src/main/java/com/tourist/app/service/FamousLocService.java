package com.tourist.app.service;

import java.io.IOException;
import java.util.List;
import com.tourist.app.model.famousLoc;

public interface FamousLocService {

	public Integer saveFPlace(famousLoc f) throws IOException;
	public List<famousLoc> getAllFPlaces();
	public void deleteFPlace(Integer id);
	public famousLoc getFPlaceById(Integer id);
	
}
