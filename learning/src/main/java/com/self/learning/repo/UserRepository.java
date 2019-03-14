package com.self.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.self.learning.entity.UserEnt;

public interface UserRepository extends JpaRepository<UserEnt, Integer> {
	public UserEnt findByUsername(String username);
}
