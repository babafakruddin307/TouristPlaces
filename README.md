# TouristPlaces
Implementing Spring boot Rest by using one to many relationship

**This project contains**

Spring Boot Rest operations
Spring data JPA
DTO Design pattern 
One To many relationship implementation

Every tourist place has different famous locations to visit, here every single place have many locations to visit like one place contains many locations

I have implemented many to one relationship by using spring boot rest .

**Model classes**

```
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

```

```
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

```

**service interface**

```
package com.tourist.app.service;

import java.util.List;

import com.tourist.app.model.places;

public interface PlaceService {

	public Integer savePlace(places p);
	public List<places> getAllPlaces();
	public void deletePlace(Integer id);
	public places getPlaceById(Integer id);
}

```

```
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

```


**repository interfaces**

```
package com.tourist.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourist.app.model.places;
@Repository
public interface PlaceReposiory extends JpaRepository<places, Integer> {

}

```

```
package com.tourist.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourist.app.model.famousLoc;
@Repository
public interface FamousLocRepository extends JpaRepository<famousLoc, Integer> {

}

```

**service implementatios**

```
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

```

```
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

```

**DTO class**

```
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

```



**Controller classes**

```
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

```

```
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

```
