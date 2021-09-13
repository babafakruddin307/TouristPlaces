package com.tourist.app.controller;



import java.util.List;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourist.app.model.places;
import com.tourist.app.service.PlaceService;

@RestController
@CrossOriginResourceSharing(allowAllOrigins=true)
@RequestMapping("/places")
public class placesController {

	@Autowired
	private PlaceService service;
	
	
	//@RequestMapping(value="/all",method=RequestMethod.GET)
	@GetMapping("/all")
	public List<places> showReg() {
	return service.getAllPlaces();
	}

	//@RequestMapping(value="/all/{id}",method=RequestMethod.GET)
	@GetMapping("/all/{id}")
	public places showReg(@PathVariable int id) {
	return service.getPlaceById(id);
	}

	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("/save")
	public places saveData(@RequestBody places place)
	{
	   service.savePlace(place);
	return place;
	}
	
	//4. Delete row based on ID
	//@RequestMapping(value="/delete/{id}")
	@DeleteMapping("/delete/{id}")
	public Integer remove(@PathVariable Integer id) {
	service.deletePlace(id);
	return id;
	}
	
	//@RequestMapping(value="/edit",method=RequestMethod.PUT)
	@PutMapping("/edit")
	public Integer showEdit(@RequestBody places place)
	{
	 return service.savePlace(place);
	}
	
	@PostMapping("/demo/ab")
	public places show(@RequestParam Integer id) {
	return service.getPlaceById(id);
	}
	@PostMapping(value="/api")
	public String readHead(@RequestHeader(required=false) String dept,
			 @RequestHeader ("Content-Type") String type, @RequestBody String mydata) {
			return "Hello Head :"+dept+" ," +type+ ",Body:" +mydata;
			 }
}
