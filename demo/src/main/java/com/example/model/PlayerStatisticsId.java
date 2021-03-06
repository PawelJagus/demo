package com.example.model;

import java.io.Serializable;

public class PlayerStatisticsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4174570034065835288L;

	private Player player;

	private Matchday matchday;

	public Player getPlayer() {
		return player;
	}

	public Matchday getMatchday() {
		return matchday;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof PlayerStatisticsId) {
			final PlayerStatisticsId o = (PlayerStatisticsId) obj;
			return o.matchday.equals(matchday) && o.player.equals(player);
		} else {
			return false;
		}
	}
}
