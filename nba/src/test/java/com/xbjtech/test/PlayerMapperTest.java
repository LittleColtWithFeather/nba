package com.xbjtech.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xbjtech.mapper.PlayerMapper;
import com.xbjtech.model.Player;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet.xml")
public class PlayerMapperTest {
	
	@Autowired
	PlayerMapper playerMapper;

	@Test
	public void testSelectPlayerById() {
		Player player = playerMapper.selectPlayerById(1);
		log.info("player {}", player);
	}

	@Test
	public void testGetPlayers() {
		Player[] players = playerMapper.getPlayers();
		log.info("players {}", players);
	}

	@Test
	public void testAddPlayer() {
		Player player = new Player();
		player.setPlayerName("Kobe Bryant");
		player.setPlayerAge(42);
		player.setPlayerHeight(1.98);
		player.setPlayerTeam("Los Angeles Lakers");
		playerMapper.addPlayer(player);
	}

	@Test
	public void testDeletePlayerById() {
		playerMapper.deletePlayerById(4);
	}

	@Test
	public void testModifyPlayerById() {
		Player player = new Player();
		player.setPlayerId(3);
		player.setPlayerName("Stephen Curry");
		player.setPlayerAge(32);
		player.setPlayerHeight(1.91);
		player.setPlayerTeam("Golden State Warriors");
		playerMapper.modifyPlayer(player);
	}

}
