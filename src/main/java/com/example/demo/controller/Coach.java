package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Player;
import com.example.demo.error.PlayerException;
import com.example.demo.service.PlayerService;

@RestController
public class Coach {
	@Autowired
	PlayerService ser;
	
	@GetMapping("players")
	public List<Player> getPlayers(){
		return ser.getPlayers();
	}
	
	@GetMapping("players/{id}")
	public Player getPlayer(@PathVariable int id) throws PlayerException {
		return ser.getPlayer(id);
	}
	
	@PostMapping("players")
	public Player savePlayer(@RequestBody Player player) {
		return ser.savePlayer(player);
	}
	
	@PutMapping("players/{id}")
	public Player updatePlayer(@PathVariable int id, @RequestBody Player player) throws PlayerException {
		return ser.updatePlayer(id, player);
	}
	
	@DeleteMapping("players/{id}")
	public Player deletePlayer(@PathVariable int id) throws PlayerException {
		return ser.deletePlayer(id);
	}
}
