package com.app.rys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.rys.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
