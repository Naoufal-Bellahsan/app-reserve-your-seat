package com.app.rys.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rys.models.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>{
			

}
