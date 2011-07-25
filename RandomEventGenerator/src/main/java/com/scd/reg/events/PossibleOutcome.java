package com.scd.reg.events;

public class PossibleOutcome {

	private String name;
	private int value;
	
	public PossibleOutcome(String eventName, int value) {
		this.setName(eventName);
		this.setValue(value);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getName()).append("-").append(getValue());
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String outcomeName) {
		this.name = outcomeName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int outcomeValue) {
		this.value = outcomeValue;
	}

}
