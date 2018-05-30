package com.jaga.springrest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jaga.springrest.bean.State;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class StateService {

	public static HashMap<Integer, State> getStateMap() {
		return stateMap;
	}

	static HashMap<Integer, State> stateMap = getStateMap();

	public StateService() {
		super();

		if (stateMap == null) {
			stateMap = new HashMap<Integer, State>();
			// Creating some objects of State while initializing
			State tamilNadu = new State(1, "TamilNadu", 10000);
			State karnataka = new State(4, "Karnataka", 20000);
			State kerala = new State(3, "Kerala", 8000);
			State andraPradesh = new State(2, "AndraPradesh", 7000);

			stateMap.put(1, tamilNadu);
			stateMap.put(4, karnataka);
			stateMap.put(3, kerala);
			stateMap.put(2, andraPradesh);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAllStates() {
		List states = new ArrayList(stateMap.values());
		return states;
	}

	public State getState(int id) {
		State state = stateMap.get(id);
		return state;
	}

	public State addState(State state) {
		state.setId(getMaxId() + 1);
		stateMap.put(state.getId(), state);
		return state;
	}

	public State updateState(State state) {
		if (state.getId() <= 0)
			return null;
		stateMap.put(state.getId(), state);
		return state;

	}

	public void deleteState(int id) {
		stateMap.remove(id);
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : stateMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
}
