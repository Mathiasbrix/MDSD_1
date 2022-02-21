package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Machine {
	public ArrayList<State> states = new ArrayList<>();
	public HashMap<String, Integer> integers = new HashMap<>();
	public State initialState;

	public List<State> getStates() {
		return this.states;
	}

	public State getInitialState() {
		return this.initialState;
	}

	public State getState(String string) {
		for (State s: states) {
			if(s.name == (string)){
				return s;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String string) {
		return integers.containsKey(string);
	}

}
