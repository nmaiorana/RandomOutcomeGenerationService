package com.scd.reg.events;

import java.util.ArrayList;
import java.util.List;

public class Event {
	private String name = "Event";
	private List<PossibleOutcome> outcomes = new ArrayList<PossibleOutcome>();
	private int value = 0;
	
	public void addOutcome(PossibleOutcome outcome) {
		getOutcomes().add(outcome);
		value += outcome.getValue();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PossibleOutcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<PossibleOutcome> outcomes) {
		this.outcomes = outcomes;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
