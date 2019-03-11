package com.self.learning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.learning.entity.Player;
import com.self.learning.entity.Team;
import com.self.learning.repo.PlayerRepository;
import com.self.learning.repo.TeamRepository;
import com.self.learning.response.PlayerResp;

@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public List<PlayerResp> getAllTeamPlayers(long teamId) {
		List<PlayerResp> result = new ArrayList<PlayerResp>();
		List<Player> players = playerRepository.findByTeamId(teamId);
		players.forEach(it -> result.add(new PlayerResp(it.getName())));
		return result;
	}

	@Override
	public void addBarcelonaPlayer(String name, String position, int number) {

		Optional<Team> barcelona = teamRepository.findById(1L);
		Player newPlayer = new Player();
		newPlayer.setName(name);
		newPlayer.setPosition(position);
		newPlayer.setNum(number);
		newPlayer.setTeam(barcelona.get());
		playerRepository.save(newPlayer);
	}
}
