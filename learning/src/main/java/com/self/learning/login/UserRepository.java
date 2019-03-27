package com.self.learning.login;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEnt, Integer> {
	public UserEnt findByUsername(String username);
	
	public List<UserEnt> findAll();
}
