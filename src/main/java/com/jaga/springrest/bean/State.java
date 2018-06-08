package com.jaga.springrest.bean;

/**
 * 
 * @author Jagatheshwaran
 * @since 27/5/2018
 *
 */
public class State {

	int id;
	String stateName;
	long population;

	public State() {
		super();
	}

	public State(int i, String stateName, long population) {
		super();
		this.id = i;
		this.stateName = stateName;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

}
