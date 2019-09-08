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

import com.smoothstack.airlineAdmin.entity.Flight;
import com.smoothstack.airlineAdmin.service.FlightService;

@RestController
@RequestMapping("/admin")
public class FlightController {

	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping(value ="/flights", produces = { XML, JSON })
	public List<Flight> getAllFlights(@RequestParam(required = false, defaultValue = "100") int size) {		
		return flightService.getAllFlights(size);
	}	
	
	@GetMapping(value = "/flight/{id}", produces = { XML, JSON })
	public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
		return flightService.getFlightById(id);								 
	}
	
	@PostMapping(value ="/flight", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public Flight createFlight(@Valid @RequestBody Flight flight) {
		return flightService.createFlight(flight);
	}	

	@PutMapping(value ="/flight", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.OK)
	public Flight updateFlight(@Valid @RequestBody Flight flight) {
		return flightService.updateFlight(flight);
	}	
	
}
