package com.self.learning.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.self.learning.entity.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{

	List<Player> findAll();
	List<Player> findByTeamId(long teamId);
}
