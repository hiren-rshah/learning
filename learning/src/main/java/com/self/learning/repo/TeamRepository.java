package com.self.learning.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.self.learning.entity.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	Team findByPlayers(long playerId);
}
