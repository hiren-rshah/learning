package com.self.learning.service;

import java.util.List;

import com.self.learning.response.PlayerResp;

public interface SoccerService {
	public List<PlayerResp> getAllTeamPlayers(long teamId);
	public void addBarcelonaPlayer(String name, String position, int number);
}
