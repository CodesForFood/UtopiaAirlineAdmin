package com.smoothstack.airlineAdmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.airlineAdmin.entity.TravelAgent;

public interface TravelAgentDAO extends JpaRepository<TravelAgent, Integer>{

	
}
