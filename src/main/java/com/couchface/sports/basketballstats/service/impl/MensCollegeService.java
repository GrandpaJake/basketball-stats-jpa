package com.couchface.sports.basketballstats.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.couchface.sports.basketballstats.entity.Game;
import com.couchface.sports.basketballstats.entity.Lineup;
import com.couchface.sports.basketballstats.entity.Player;
import com.couchface.sports.basketballstats.entity.Team;
import com.couchface.sports.basketballstats.service.BasketballStatsService;

public class MensCollegeService implements BasketballStatsService {
	
	public Game addNewGame(Game game) {
		Game persistedGame = new Game();
		persistedGame.setArena(game.getArena());
		persistedGame.setHomeTeam(findOrAddTeam(game.getHomeTeam()));
		persistedGame.setAwayTeam(findOrAddTeam(game.getAwayTeam()));
		persistedGame.setGameId(game.getGameId());
		List<Lineup> lineupsWithPlayers = replaceLineupPlayersWithHomeAndAwayTeamPlayers(game.getLineups(),persistedGame.getHomeTeam(),persistedGame.getAwayTeam());
		persistedGame.getLineups().addAll(findOrAddLineups(lineupsWithPlayers));
		persistedGame.setGameTime(game.getGameTime());
		persistedGame.setId(game.getId());
		persistedGame.setOfficialOne(game.getOfficialOne());
		persistedGame.setOfficialTwo(game.getOfficialTwo());
		persistedGame.setOfficialThree(game.getOfficialThree());
		
		return addGame(persistedGame);
	}
	
	private Game addGame(Game game) {
		//TODO - make this use entity manager to persist game, able to cascade all, as all entity fields have been persisted
		return null;
	}

	private List<Lineup> replaceLineupPlayersWithHomeAndAwayTeamPlayers(
			List<Lineup> lineups, Team homeTeam, Team awayTeam) {
		ArrayList<Lineup> fixedLineups = new ArrayList<Lineup>();
		HashMap<Long,Player> playersFromTeams = new HashMap<Long,Player>();
		for (Player player : homeTeam.getPlayers()) {
			playersFromTeams.put(player.getId(), player);
		}
		for (Player player : awayTeam.getPlayers()) {
			playersFromTeams.put(player.getId(), player);
		}
		for (Lineup lineup : lineups) {
			Lineup fixedLineup = lineup.shallowCopy();
			fixedLineup.getPlayers().clear();
			for (Player player : lineup.getPlayers()) {
				fixedLineup.getPlayers().add(playersFromTeams.get(player.getId()));
			}
			fixedLineups.add(fixedLineup);
		}
		return fixedLineups;
	}

	private List<Lineup> findOrAddLineups(List<Lineup> lineups) {
		ArrayList<Lineup> persistedLineups = new ArrayList<Lineup>();
		for (Lineup lineup : lineups) {
			Lineup persistedLineup = findLineup(lineup);
			if (persistedLineup == null) {
				persistedLineup = addLineup(lineup);
			}
		}
		return persistedLineups;
	}

	private Lineup addLineup(Lineup lineup) {
		//TODO - make this use entity manager to persist lineup, able to cascade all, as all entity fields have been persisted
		return null;
	}

	private Lineup findLineup(Lineup lineup) {
		// TODO - make this search for a lineup, should generically handle searching based on fields of lineup and ids of players
		return null;
	}

	private Team findOrAddTeam(Team team) {
		Team persistedTeam = findTeamIgnorePlayers(team);
		if (persistedTeam == null) {
			persistedTeam = team.shallowCopy();
			persistedTeam.getPlayers().clear();
			for (Player player : team.getPlayers()) {
				persistedTeam.getPlayers().add(findOrAddPlayer(player));
			}
			persistedTeam = addTeam(team);
		} else {
			for (Player player : team.getPlayers()) {
				if (!isPlayerInList(player, persistedTeam.getPlayers())) {
					persistedTeam.getPlayers().add(addPlayer(player));
				}
			}
			persistedTeam = updateTeam(persistedTeam);
		}
		return persistedTeam;
	}

	private Team updateTeam(Team persistedTeam) {
		// TODO - make this use entity manager to persist, cascading all
		return null;
	}

	private boolean isPlayerInList(Player player, List<Player> players) {
		boolean found = false;
		for (Player listPlayer : players) {
			if (player.getId() == listPlayer.getId()) {
				found = true;
			}
		}
		return found;
	}

	private Player findOrAddPlayer(Player player) {
		Player persistedPlayer = findPlayer(player);
		if (persistedPlayer == null) {
			persistedPlayer = addPlayer(player);
		}
		return persistedPlayer;
	}

	private Player addPlayer(Player player) {
		//TODO - make this use entity manager to persist player, able to cascade all, as all entity fields have been persisted
		return null;
	}

	private Player findPlayer(Player player) {
		// TODO - make this search for a player by all fields, including team id
		return null;
	}

	private Team addTeam(Team team) {
		// TODO - make this use entity manager to persist team, able to cascade all
		return null;
	}

	private Team findTeamIgnorePlayers(Team team) {
		// TODO - make this search for a team by all fields, no search by players
		return null;
	}

}
