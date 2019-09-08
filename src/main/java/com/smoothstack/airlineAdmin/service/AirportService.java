package com.smoothstack.airlineAdmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.airlineAdmin.dao.AirportDAO;
import com.smoothstack.airlineAdmin.entity.Airport;


@Service
public class AirportService {

	@Autowired
	private AirportDAO airportDAO;
	
	@Transactional
	public List<Airport> getAllAirports(int size) {
		Pageable limit = PageRequest.of(0,size);
		return airportDAO.findAll(limit).getContent();		
	}

	@Transactional
	public ResponseEntity<Airport> getAirportByCode(String code) {
		Optional<Airport> airport = airportDAO.findById(code);		
				
		return !airport.isPresent() ? new ResponseEntity<Airport>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<Airport>(airport.get(), HttpStatus.OK);						 
	}
	
	@Transactional
	public Airport createAirport(Airport airport) {
		return airportDAO.save(airport);
	}	

	@Transactional
	public Airport updateAirport(Airport airport) {
		return airportDAO.save(airport);
	}		
}
