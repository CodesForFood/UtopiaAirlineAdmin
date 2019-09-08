package com.smoothstack.airlineAdmin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.airlineAdmin.entity.Booking;

public interface BookingDAO extends JpaRepository<Booking, Integer>{

	@Query(value = "SELECT * FROM utopiaairlines.booking WHERE traveler_id = ?1", nativeQuery = true)
	Optional<List<Booking>> getBookingsOfTravler(Integer id);

	@Query(value = "SELECT * FROM utopiaairlines.booking WHERE flight_id = ?1", nativeQuery = true)
	Optional<List<Booking>> getBookingsOfFlight(Integer id);
	
	@Query(value = "SELECT * FROM utopiaairlines.booking WHERE travel_agent_id = ?1", nativeQuery = true)
	Optional<List<Booking>> getBookingsOfTravelAgent(Integer id);
	
}
