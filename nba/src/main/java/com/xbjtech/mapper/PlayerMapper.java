package com.xbjtech.mapper;

import com.xbjtech.model.Player;

public interface PlayerMapper {
	
	Player selectPlayerById(Integer playerId);
	
	Player[] getPlayers();
	
	void addPlayer(Player player);
	
	void deletePlayerById(Integer playerId);
	
	void modifyPlayer(Player player);
	
}
