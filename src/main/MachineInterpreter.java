package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {
	Machine machine;
	State currentState;
	public void run(Machine m) {
		machine = m;
		currentState = machine.initialState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String string) {
		if(currentState.getTransitionByEvent(string)!= null) {
			Transition transition = currentState.getTransitionByEvent(string);

			if (transition.isConditional) {
				System.out.println("IsConditional");
				if (runConditional(transition)) {
					System.out.println("RunConditional");
					if (transition.hasOperation) {
						System.out.println("HasOperation");
						runOperation(transition);
						currentState = machine.getState(transition.target.name);
					}
				}
			} else {
				if (transition.hasOperation) {
					System.out.println("Else IsConditional");
					runOperation(transition);
				}
				currentState = machine.getState(transition.target.name);
			}
		}

		
	}
	public int getInteger(String string) {
		return machine.integers.get(string);
	}
	public boolean runConditional(Transition transition){
		Integer value = machine.integers.get(transition.conditionVariableName);
		Integer value2 = transition.conditionComparedValue;

		if(transition.isConditionEqual){
			return (value == value2);
		}
		else if(transition.isConditionGreaterThan){
			return value >= value2;
		}
		else if(transition.isConditionLessThan){
			return value <= value2;
		}

		return true;
	}

	public void runOperation(Transition transition){
		String name = transition.operationVariableName;
		if(transition.hasSetOperation){
			System.out.println("Set");
			machine.integers.put(transition.operationVariableName, transition.operationValue);
		}
		if(transition.hasDecrementOperation){
			System.out.println("Decrement");
			Integer current = machine.integers.get(name);
			Integer newValue = current--;
			machine.integers.put(name, newValue);
		}
		if(transition.hasIncrementOperation){
			System.out.println("Increment");
			Integer current = machine.integers.get(name);
			Integer newValue = current++;
			machine.integers.put(name, newValue);
		}


}}
