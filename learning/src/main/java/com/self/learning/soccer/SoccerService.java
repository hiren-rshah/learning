package com.self.learning.soccer;

import java.util.List;

public interface SoccerService {
	public List<PlayerResp> getAllTeamPlayers(long teamId);
	public void addBarcelonaPlayer(String name, String position, int number);
}
