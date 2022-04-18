package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Integer> {

	public List<Hall> findByHallCity(String city);

	public List<Hall> findByHallCityAndHallLocation(String city, String location);

	public List<Hall> findByHallCityAndHallCapacity(String city, int capacity);

}
