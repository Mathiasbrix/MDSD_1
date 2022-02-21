package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {

	public String name;
	public ArrayList<Transition> transitions = new ArrayList<>();

	public State(String name) {
		this.name = name;
	}

	public Object getName() {
		return name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public Transition getTransitionByEvent(String string) {
		for (Transition t: transitions) {
			if(t.getEvent().equals(string)){
				return t;
			}
		}
		return null;
	}

}