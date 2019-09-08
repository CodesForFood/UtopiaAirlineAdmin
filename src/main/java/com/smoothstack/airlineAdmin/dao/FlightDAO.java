package com.smoothstack.airlineAdmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.airlineAdmin.entity.Flight;

public interface FlightDAO extends JpaRepository<Flight, Integer> {

}
