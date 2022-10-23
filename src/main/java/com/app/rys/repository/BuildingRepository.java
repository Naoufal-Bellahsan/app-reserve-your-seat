package com.app.rys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rys.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
