package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Club;
import com.example.model.Match;
import com.example.model.Matchday;
import com.example.model.Player;
import com.example.model.PlayerStatistics;
import com.example.model.repository.ClubRepository;
import com.example.model.repository.MatchRepository;
import com.example.model.repository.MatchdayRepository;
import com.example.model.repository.PlayerRepository;
import com.example.model.repository.PlayerStatisticsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = { "spring.profiles.active: dev",
		"debug: false" })
public class DemoApplicationTests {
	@Autowired
	private MatchdayRepository matchdayRepository;
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private PlayerStatisticsRepository playerStatisticsRepository;
	
	@Before
	public void init() {
		final Matchday matchday = matchdayRepository.save(new Matchday(1));
		final Club club1 = clubRepository.save(new Club("Klub1"));
		final Club club2 = clubRepository.save(new Club("Klub2"));
		final Match match = matchRepository.save(new Match(matchday, club1, club2));
		final Player player = playerRepository.save(new Player(1, "Jan", "Kowalski", club1));
		playerStatisticsRepository.save(new PlayerStatistics(matchday, player, match));
	}

	@Test
	public void contextLoads() {
	}

}
