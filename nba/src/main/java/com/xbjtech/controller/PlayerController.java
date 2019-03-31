package com.xbjtech.controller;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xbjtech.Exception.NoPlayerException;
import com.xbjtech.model.Player;
import com.xbjtech.service.PlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	//获取球员列表页面
	@GetMapping("/playerList")
	public String getPlayerListPage() {
		return "playerList";	
	}
	
	//获取球员添加页面
	@GetMapping("/setPlayer")
	public String getSetPlayerPage() {
		return "setPlayer";	
	}
	
	//获取球员修改页面
	@GetMapping("/modifyPlayer")
	public String getModifyPlayerPage() {
		return "modifyPlayer";
	}
	
	
	//获取球员列表
	@GetMapping("/getPlayers")
	@ResponseBody
	public String getPlayers() {
		Player[] players = null;
		try {
			players = playerService.getPlayers();
		}catch(NoPlayerException e) {
			return "{\"msg\":\"There is no player now... Please add a new player\"}";
		}
		String jsonString = new JSONArray(players).toString();
		return jsonString;	
	}
	
	
	//添加球员
	@PostMapping("/addPlayer")
	@ResponseBody
	public String addPlayer(@RequestBody String jsonString) {
		Gson gson = new Gson();
		Player player = gson.fromJson(jsonString, Player.class);
		try {
			playerService.addPlayer(player);
		} catch(Exception e) {
			return "{\"msg\":\"Sorry, add player failed... Please check your network settings\"}";
		}
		return "{\"msg\":\"Player added successfully!!!\"}";	
	}
	
	//删除球员
	@PostMapping("/deletePlayer")
	@ResponseBody
	public String deletePlayer(@RequestBody String jsonString) {
		Gson gson = new Gson();
		Map jsonMap = gson.fromJson(jsonString, Map.class);
		int playerId = Integer.parseInt((String) jsonMap.get("playerId"));
		System.out.println(playerId);
		try {
			playerService.deletePlayerById(playerId);
		} catch(Exception e) {
			return "{\"msg\":\"Sorry, remove player failed... Please check your network settings\"}";
		}
		return "{\"msg\":\"Player removed successfully!!!\"}";	
	}
	
	//根据playerId获取球员信息
	@PostMapping("/getPlayerById")
	@ResponseBody
	public String getPlayerById(@RequestBody String jsonString) {
		Gson gson = new Gson();
		Map jsonMap = gson.fromJson(jsonString, Map.class);
		int playerId = Integer.parseInt((String) jsonMap.get("playerId"));
		Player player = null;
		try {
			player = playerService.selectPlayerById(playerId);
		} catch(Exception e) {
			return "{\"msg\":\"Sorry, can not get player message... Please check your network settings\"}";
		}
		String playerString = gson.toJson(player);
		return playerString;	
	}
	
	//修改球员信息
	@PostMapping("/modifyPlayer")
	@ResponseBody
	public String modifyPlayer(@RequestBody String jsonString) {
		Gson gson = new Gson();
		Player player = gson.fromJson(jsonString, Player.class);
		try {
		playerService.modifyPlayer(player);
		} catch(Exception e) {
			return "{\"msg\":\"Sorry, modify player failed... Please check your network settings\"}";
		}
		return "{\"msg\":\"Player modified successfully!!!\"}";	
	}
}
