package com.app.rys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rys.models.Floor;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long>{

}
