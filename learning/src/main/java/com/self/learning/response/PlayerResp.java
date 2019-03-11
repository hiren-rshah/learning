package com.self.learning.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.self.learning.entity.Player;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PlayerResp {

	@JsonProperty("playerNameeeeee")
	private String playerName;

	public PlayerResp(String playerName) {
		this.playerName = playerName;
	}
}
