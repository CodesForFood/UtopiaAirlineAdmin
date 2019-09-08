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

import com.smoothstack.airlineAdmin.entity.TravelAgent;
import com.smoothstack.airlineAdmin.service.TravelAgentService;

@RestController
@RequestMapping("admin")
public class TravelAgentController {
	
	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private TravelAgentService travelAgentService;	

	@GetMapping(value ="/travelAgents", produces = { XML, JSON })
	public List<TravelAgent> getAllTravelAgents(@RequestParam(required = false, defaultValue = "100") int size) {		
		return travelAgentService.getAllTravelAgents(size);
	}	
	
	@GetMapping(value = "/travelAgent/{id}", produces = { XML, JSON })
	public ResponseEntity<TravelAgent> getTravelAgentById(@PathVariable Integer id) {
		return travelAgentService.getTravelAgentById(id);								 
	}
	
	@PostMapping(value ="/travelAgent", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public TravelAgent createTravelAgent(@Valid @RequestBody TravelAgent travelAgent) {
		return travelAgentService.createTravelAgent(travelAgent);
	}	

	@PutMapping(value ="/travelAgent", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.OK)
	public TravelAgent updateTravelAgent(@Valid @RequestBody TravelAgent travelAgent) {
		return travelAgentService.updateTravelAgent(travelAgent);
	}	
	
}
