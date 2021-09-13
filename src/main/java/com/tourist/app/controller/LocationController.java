package com.tourist.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourist.app.dto.FLocationDataRequest;
import com.tourist.app.model.famousLoc;
import com.tourist.app.model.places;
import com.tourist.app.service.FamousLocService;
import com.tourist.app.service.PlaceService;

@RestController
@RequestMapping(value="/floc")
public class LocationController {
	
	@Autowired
	private FamousLocService Fservice;
	
	
	@Autowired
	private PlaceService Pservice;
	
	
	//@RequestMapping(value="/locations",method=RequestMethod.POST)
	@PostMapping("/locations")
	public Integer saveLocations(@RequestBody FLocationDataRequest request) throws IOException {
		
		places place=Pservice.getPlaceById(request.getPinCode());
		famousLoc loc=new famousLoc();
		loc.setPlace(place);
		loc.setLocatName(request.getLocatName());
		loc.setDescription(request.getDescription());
		return Fservice.saveFPlace(loc);
	}	
}
