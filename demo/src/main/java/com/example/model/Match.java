package com.example.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Match implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5357006078589801886L;
	
	@EmbeddedId
	private MatchKey primaryKey;

	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Club awayTeam;
	
	public Match() {
		// intentionally left empty
	}
	
	public Match(final Matchday matchday, final Club homeTeam, final Club awayTeam) {
		this.primaryKey = new MatchKey(matchday, homeTeam);
		this.awayTeam = awayTeam;
	}
	
	public MatchKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(MatchKey primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Club getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Club awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Match && ((Match) obj).primaryKey.equals(primaryKey);
	}
	
	@Override
	public int hashCode() {
		return primaryKey.hashCode();
	}
}
