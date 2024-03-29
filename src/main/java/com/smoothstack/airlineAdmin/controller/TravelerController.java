package com.smoothstack.airlineAdmin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.airlineAdmin.entity.Traveler;
import com.smoothstack.airlineAdmin.service.TravelerService;

@RestController
@RequestMapping("admin")
public class TravelerController {

	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private TravelerService travelService;
	
	@GetMapping(value ="/travelers", produces = { XML, JSON })
	public List<Traveler> getAllTravelers(@RequestParam(required = false, defaultValue = "100") int size) {		
		return travelService.getAllTravelers(size);
	}	
	
	@GetMapping(value = "/traveler/{id}", produces = { XML, JSON })
	public ResponseEntity<Traveler> getTravelerById(@PathVariable Integer id) {
		return travelService.getTravelerById(id);								 
	}		
	
	@PostMapping(value ="/traveler", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public Traveler createTraveler(@Valid @RequestBody Traveler traveler) {
		return travelService.createTraveler(traveler);
	}	

	@PutMapping(value ="/traveler", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.OK)
	public Traveler updateTraveler(@Valid @RequestBody Traveler traveler) {
		return travelService.updateTraveler(traveler);
	}	
	
}
