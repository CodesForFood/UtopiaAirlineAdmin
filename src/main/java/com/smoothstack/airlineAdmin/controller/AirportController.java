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

import com.smoothstack.airlineAdmin.entity.Airport;
import com.smoothstack.airlineAdmin.service.AirportService;

@RestController
@RequestMapping("/admin")
public class AirportController {
	
	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private AirportService airportService;
	
	@GetMapping(value ="/airports", produces = { XML, JSON })
	public List<Airport> getAllAirports(@RequestParam(required = false, defaultValue = "100") int size) {		
		return airportService.getAllAirports(size);
	}	
	
	@GetMapping(value = "/airport/{code}", produces = { XML, JSON })
	public ResponseEntity<Airport> getAirportById(@PathVariable String code) {
		return airportService.getAirportByCode(code);								 
	}
	
	@PostMapping(value ="/airport", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public Airport createAirport(@Valid @RequestBody Airport traveler) {
		return airportService.createAirport(traveler);
	}	

	@PutMapping(value ="/airport", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.OK)
	public Airport updateAirportr(@Valid @RequestBody Airport traveler) {
		return airportService.updateAirport(traveler);
	}	
	
}
