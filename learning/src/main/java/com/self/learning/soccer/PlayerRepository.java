package com.self.learning.soccer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{

	List<Player> findAll();
	List<Player> findByTeamId(long teamId);
}
