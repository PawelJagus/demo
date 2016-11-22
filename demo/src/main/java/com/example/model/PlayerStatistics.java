package com.example.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;

@Entity
@IdClass(PlayerStatisticsId.class)
public class PlayerStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 953546382951282268L;
	
	@Id
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Player player;
	
	@Id
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Matchday matchday;

	@ManyToOne(optional = false)
	@JoinColumns({ @JoinColumn(name = "matchday_matchdaynumber", referencedColumnName = "matchday_matchdaynumber"),
			@JoinColumn(name = "hometeam_name", referencedColumnName = "hometeam_name") })
	private Match match;

	@Column(nullable = false)
	private boolean playedFromTheFirstWhistleblow;

	@Min(0)
	@Column(nullable = false)
	private int enteredTheFieldAtInSeconds;

	@Min(0)
	@Column(nullable = false)
	private int leftTheFieldAtInSeconds;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable
	@MapKeyEnumerated(EnumType.STRING)
	private Map<ScoreType, Integer> statistics = new HashMap<>();
	
	public PlayerStatistics() {
		// intentionally left empty
	}
	
	public PlayerStatistics(final Matchday matchday, final Player player, final Match match) {
		this.matchday = matchday;
		this.player = player;
		this.match = match;
	}

	public Matchday getMatchday() {
		return matchday;
	}

	public void setMatchday(Matchday matchday) {
		this.matchday = matchday;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isPlayedFromTheFirstWhistleblow() {
		return playedFromTheFirstWhistleblow;
	}

	public void setPlayedFromTheFirstWhistleblow(boolean playedFromTheFirstWhistleblow) {
		this.playedFromTheFirstWhistleblow = playedFromTheFirstWhistleblow;
	}

	public int getEnteredTheFieldAtInSeconds() {
		return enteredTheFieldAtInSeconds;
	}

	public void setEnteredTheFieldAtInSeconds(int enteredTheFieldAtInSeconds) {
		this.enteredTheFieldAtInSeconds = enteredTheFieldAtInSeconds;
	}

	public int getLeftTheFieldAtInSeconds() {
		return leftTheFieldAtInSeconds;
	}

	public void setLeftTheFieldAtInSeconds(int leftTheFieldAtInSeconds) {
		this.leftTheFieldAtInSeconds = leftTheFieldAtInSeconds;
	}

	public Map<ScoreType, Integer> getStatistics() {
		return statistics;
	}

	public void setStatistics(Map<ScoreType, Integer> statistics) {
		this.statistics = statistics;
	}

	@Override
	public int hashCode() {
		return Objects.hash(player, match.getPrimaryKey().getMatchday());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof PlayerStatistics) {
			final PlayerStatistics o = (PlayerStatistics) obj;
			return o.player.equals(player)
					&& o.match.getPrimaryKey().getMatchday().equals(match.getPrimaryKey().getMatchday());
		} else {
			return false;
		}
	}
}
