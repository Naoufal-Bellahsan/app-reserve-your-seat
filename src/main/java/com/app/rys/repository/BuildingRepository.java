package com.app.rys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rys.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
	
	List<Building> findByCity(String city);
	Building findByAdrress(String adrress);
	
	List<Building> findByCityAndAdrress(String city, String adrress);
	// Se puede con Query
	/*@Query(value = "SELECT * FROM Building b WHERE b.city = ?1 and b.adrress = ?2", 
			  nativeQuery = true)
	List<Building> searchByCityAndAdrress(String city, String adrress);*/
}
