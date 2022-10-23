package com.app.rys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rys.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
