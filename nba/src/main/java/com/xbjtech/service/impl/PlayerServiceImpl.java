package com.xbjtech.service.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbjtech.Exception.NoPlayerException;
import com.xbjtech.Exception.PlayerNotFoundException;
import com.xbjtech.mapper.PlayerMapper;
import com.xbjtech.model.Player;
import com.xbjtech.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	PlayerMapper playerMapper;

	@Override
	public Player selectPlayerById(Integer playerId) {
		Player player = playerMapper.selectPlayerById(playerId);
		return player;
	}

	@Override
	public Player[] getPlayers() throws NoPlayerException {
		
		Player[] players = playerMapper.getPlayers();
		if(players.length == 0) {
			throw new NoPlayerException("Sorry. There's no player in DataBase now...");
		}
		return players;
	}

	@Override
	public void addPlayer(Player player) {
		playerMapper.addPlayer(player);
	}

	@Override
	public void deletePlayerById(Integer playerId) {
		playerMapper.deletePlayerById(playerId);

	}

	@Override
	public void modifyPlayer(Player player)  {
		playerMapper.modifyPlayer(player);
	}

}
