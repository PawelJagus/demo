package com.example.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Embeddable
public class MatchKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1585782549062878053L;

	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Matchday matchday;

	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Club homeTeam;
	
	public MatchKey() {
		// intentionally left empty
	}
	
	public MatchKey(final Matchday matchday, final Club homeTeam) {
		this.matchday = matchday;
		this.homeTeam = homeTeam;
	}

	public Matchday getMatchday() {
		return matchday;
	}

	public void setMatchday(Matchday matchday) {
		this.matchday = matchday;
	}

	public Club getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Club homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof MatchKey) {
			final MatchKey o = (MatchKey) obj;
			return o.matchday.equals(matchday) && o.homeTeam.equals(homeTeam);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matchday, homeTeam);
	}
}
