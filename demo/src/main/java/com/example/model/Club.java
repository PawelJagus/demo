package com.example.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Club implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1472421945991951007L;
	
	@Id
	private String name;
	
	public Club() {
		// intentionally left empty
	}
	
	public Club(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Club && ((Club) obj).name.equals(name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
