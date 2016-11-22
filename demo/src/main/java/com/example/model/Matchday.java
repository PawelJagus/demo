package com.example.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Matchday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1153173220330692997L;

	@Id
	@Min(1)
	private int matchdayNumber;
	
	public Matchday() {
		// intentionally left empty
	}
	
	public Matchday(final int matchdayNumber) {
		this.matchdayNumber = matchdayNumber;
	}

	public int getMatchdayNumber() {
		return matchdayNumber;
	}

	public void setMatchdayNumber(int matchdayNumber) {
		this.matchdayNumber = matchdayNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Matchday && ((Matchday) obj).matchdayNumber == matchdayNumber;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matchdayNumber);
	}
}
