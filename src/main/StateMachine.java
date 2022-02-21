package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

import java.util.HashMap;

public class StateMachine {
	public Machine machine = new Machine();

	public State latestState;
	public Transition latestTransition;
	public Machine build() {

		return this.machine;
	}

	public StateMachine state(String string) {
		if(!machine.getStates().contains(string)){
			latestState = new State(string);
			machine.states.add(latestState);
		}
		return this;
	}

	public StateMachine initial() {
		machine.initialState = machine.states.get(machine.states.size() - 1);
		return this;
	}

	public StateMachine when(String string) {
		latestTransition = new Transition();
		latestTransition.event = string;
		latestState.transitions.add(latestTransition);
		return this;
	}

	public StateMachine to(String string) {
		if(machine.getStates().contains(string)){
			latestTransition.target = machine.getStates().get(machine.getStates().indexOf(string));
		}
		else{
		State state = new State(string);
		machine.states.add(latestState);
		latestTransition.target = state;}
		return this;
	}

	public StateMachine integer(String string) {
		machine.integers.put(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		latestTransition.hasOperation = true;
		latestTransition.hasSetOperation = true;
		latestTransition.operationVariableName = string;
		latestTransition.operationValue = i;
		System.out.println("Run");
		return this;
	}

	public StateMachine increment(String string) {
		latestTransition.hasOperation = true;
		latestTransition.operationVariableName = string;
		latestTransition.hasIncrementOperation = true;
		return this;
	}

	public StateMachine decrement(String string) {
		latestTransition.hasOperation = true;
		latestTransition.operationVariableName = string;
		latestTransition.hasDecrementOperation = true;
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		latestTransition.conditionVariableName = string;
		latestTransition.conditionComparedValue = i;
		latestTransition.isConditional = true;
		latestTransition.isConditionEqual = true;
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		latestTransition.isConditional = true;
		latestTransition.conditionVariableName = string;
		latestTransition.conditionComparedValue = i;
		latestTransition.isConditionGreaterThan = true;
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		latestTransition.isConditional = true;
		latestTransition.conditionVariableName = string;
		latestTransition.conditionComparedValue = i;
		latestTransition.isConditionLessThan = true;
		return this;
	}

}
