package com.smoothstack.airlineAdmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.airlineAdmin.entity.Traveler;

public interface TravelerDAO extends JpaRepository<Traveler, Integer>{

}
