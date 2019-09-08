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

import com.smoothstack.airlineAdmin.entity.Counter;
import com.smoothstack.airlineAdmin.service.CounterService;

@RestController
@RequestMapping("admin")
public class CounterController {

	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private CounterService counterService;
	
	@GetMapping(value ="/counters", produces = { XML, JSON })
	public List<Counter> getAllTravelers(@RequestParam(required = false, defaultValue = "100") int size) {		
		return counterService.getAllCounters(size);
	}	
	
	@GetMapping(value = "/counter/{id}", produces = { XML, JSON })
	public ResponseEntity<Counter> getTravelerById(@PathVariable Integer id) {
		return counterService.getCounterById(id);								 
	}
	
	@GetMapping(value="/counter/airport/{code}", produces = { JSON, XML})
	public ResponseEntity<Counter> getCounterByAirportCode(@PathVariable String code){
		return counterService.getCounterByAirport(code);
	}	
	
	@PostMapping(value ="/counter", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public Counter createTraveler(@Valid @RequestBody Counter counter) {
		return counterService.createCounter(counter);
	}	

	@PutMapping(value ="/counter", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.OK)
	public Counter updateTraveler(@Valid @RequestBody Counter counter) {
		return counterService.updateCounter(counter);
	}	
	
	
}
