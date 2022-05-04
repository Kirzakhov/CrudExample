package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Player;
import com.example.demo.error.PlayerException;
import com.example.demo.repo.PlayerRepo;

@Service
public class PlayerService {

	@Autowired
	PlayerRepo repo;
	
	public List<Player> getPlayers() {
		List<Player> pl = repo.findAll();
		return pl;
	}

	public Player getPlayer(Integer id) throws PlayerException {
		Optional<Player> pl = repo.findById(id);
		if(pl.isEmpty())
			throw new PlayerException("Player not available...");
		else
			return pl.get();
	}

	public Player updatePlayer(int id, Player player) throws PlayerException {
		Player pl;
		if(repo.existsById(id)) {
			pl = repo.findById(id).get();
			if(Objects.nonNull(player.getName()) && !"".equalsIgnoreCase(player.getName()))
				pl.setName(player.getName());
			if(Objects.nonNull(player.getRating()) && !"".equalsIgnoreCase(player.getRating()))
				pl.setRating(player.getRating());
			return repo.save(pl);
		}
		else
			throw new PlayerException("Player not found...");
		
	}

	public Player savePlayer(Player player) {
		
		return repo.save(player);
	}

	public Player deletePlayer(int id) throws PlayerException {
		Optional<Player> pl = repo.findById(id);
		if(pl.isEmpty())
			throw new PlayerException("Player not available...");
		else {
			repo.deleteById(id);
			return pl.get();
		}
	}

}
