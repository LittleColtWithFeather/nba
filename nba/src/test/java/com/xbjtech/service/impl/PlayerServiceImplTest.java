package com.xbjtech.service.impl;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xbjtech.model.Player;
import com.xbjtech.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet.xml")
public class PlayerServiceImplTest {

	@Autowired
	PlayerService playerService;
	
	@Test
	public void testSelectPlayerById() {
		Player player = playerService.selectPlayerById(1);
		log.info("player {}",player);
	}

	@Test
	public void testGetPlayers() {
		Player[] players = playerService.getPlayers();
	}

	@Test
	public void testAddPlayer() {
		Player player = new Player();
		player.setPlayerName("Kobe Bryant");
		player.setPlayerAge(42);
		player.setPlayerHeight(1.98);
		player.setPlayerTeam("Los Angeles Lakers");
		playerService.addPlayer(player);
	}

	@Test
	public void testDeletePlayerById() {
		playerService.deletePlayerById(5);
	}

	@Test
	public void testModifyPlayer() {
		Player player = new Player();
		player.setPlayerId(7);
		player.setPlayerName("Stephen Curry");
		player.setPlayerAge(32);
		player.setPlayerHeight(1.91);
		player.setPlayerTeam("Golden State Warriors");
		playerService.modifyPlayer(player);
	}

}
