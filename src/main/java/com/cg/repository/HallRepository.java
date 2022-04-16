package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Integer> {

	public List<Hall> findByCity(String city);

	public List<Hall> findByCityAndLocation(String city, String location);

	public List<Hall> findByCityAndCapacity(String city, int capacity);

}
