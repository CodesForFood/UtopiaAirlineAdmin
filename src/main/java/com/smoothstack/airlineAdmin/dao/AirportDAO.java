package com.smoothstack.airlineAdmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.airlineAdmin.entity.Airport;

public interface AirportDAO extends JpaRepository<Airport, String>{

	
	
}
