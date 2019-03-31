package com.xbjtech.service;

import org.springframework.stereotype.Service;

import com.xbjtech.Exception.NoPlayerException;
import com.xbjtech.model.Player;

public interface PlayerService {
	
	Player selectPlayerById(Integer playerId);
	
	Player[] getPlayers() throws NoPlayerException;
	
	void addPlayer(Player player);
	
	void deletePlayerById(Integer playerId);
	
	void modifyPlayer(Player player);

}
