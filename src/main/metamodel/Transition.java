package main.metamodel;

public class Transition {
	public String event;
	public State target;

	public boolean hasSetOperation = false;
	public boolean hasIncrementOperation = false;
	public boolean hasDecrementOperation = false;
	public boolean isConditional = false;
	public boolean isConditionEqual = false;
	public boolean isConditionLessThan = false;
	public boolean isConditionGreaterThan= false;
	public boolean hasOperation = false;

	public String operationVariableName;
	public Integer operationValue;

	public String conditionVariableName;
	public Integer conditionComparedValue;

	public Object getEvent() {
		return event;
	}

	public State getTarget() {
		return target;
	}

	public boolean hasSetOperation() {
		return hasSetOperation;
	}

	public boolean hasIncrementOperation() {
		return hasIncrementOperation;
	}

	public boolean hasDecrementOperation() {
		return hasDecrementOperation;
	}

	public Object getOperationVariableName() {
		return operationVariableName;
	}

	public boolean isConditional() {
		return isConditional;
	}

	public Object getConditionVariableName() {
		return conditionVariableName;
	}

	public Integer getConditionComparedValue() {
		return conditionComparedValue;
	}

	public boolean isConditionEqual() {
		return isConditionEqual;
	}

	public boolean isConditionGreaterThan() {
		return isConditionGreaterThan;
	}

	public boolean isConditionLessThan() {
		return isConditionLessThan;
	}

	public boolean hasOperation() {
		return hasOperation;
	}

}
