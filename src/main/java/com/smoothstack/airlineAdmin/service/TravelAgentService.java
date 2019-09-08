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

import com.smoothstack.airlineAdmin.dao.TravelAgentDAO;
import com.smoothstack.airlineAdmin.entity.TravelAgent;

@Service
public class TravelAgentService {

	@Autowired
	private TravelAgentDAO travelAgentDAO;
	
	@Transactional
	public List<TravelAgent> getAllTravelAgents(int size) {
		Pageable limit = PageRequest.of(0,size);
		return travelAgentDAO.findAll(limit).getContent();		
	}

	@Transactional
	public ResponseEntity<TravelAgent> getTravelAgentById(Integer id) {
		Optional<TravelAgent> travelAgent = travelAgentDAO.findById(id);		
				
		return !travelAgent.isPresent() ? new ResponseEntity<TravelAgent>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<TravelAgent>(travelAgent.get(), HttpStatus.OK);						 
	}
	
	@Transactional
	public TravelAgent createTravelAgent(TravelAgent travelAgent) {
		return travelAgentDAO.save(travelAgent);
	}	

	@Transactional
	public TravelAgent updateTravelAgent(TravelAgent travelAgent) {
		return travelAgentDAO.save(travelAgent);
	}	
}
