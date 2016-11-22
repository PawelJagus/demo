package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5308940923485674411L;

	@Id
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Club currentClub;
	
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<PlayerStatistics> playerStatistics = new ArrayList<>();
	
	public Player() {
		// intentionally left empty
	}
	
	public Player(final long id, final String name, final String surname, final Club currentClub) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.currentClub = currentClub;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Club getCurrentClub() {
		return currentClub;
	}

	public void setCurrentClub(Club currentClub) {
		this.currentClub = currentClub;
	}

	public List<PlayerStatistics> getPlayerStatistics() {
		return Collections.unmodifiableList(playerStatistics);
	}

	public void setPlayerStatistics(List<PlayerStatistics> playerStatistics) {
		this.playerStatistics = new ArrayList<>(playerStatistics);
	}
	
	public void addPlayerStatistics(final PlayerStatistics playerStatistics) {
		if (playerStatistics == null) {
			throw new IllegalArgumentException();
		}
		this.playerStatistics.add(playerStatistics);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Player && ((Player) obj).id == id;
	}
}
