package com.self.learning.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.self.learning.response.PlayerResp;
import com.self.learning.service.SoccerService;

@RestController
public class SockerCntr {

	@Autowired
	SoccerService soccerService;

	@RequestMapping(value = "/sockerTeam", method = RequestMethod.GET/*, produces = "application/json"*/)
	@ResponseBody
	public ResponseEntity<List<PlayerResp>> getTeam() {
		List<PlayerResp> players = soccerService.getAllTeamPlayers(1L);
		return ResponseEntity.ok(players);
	}
}
