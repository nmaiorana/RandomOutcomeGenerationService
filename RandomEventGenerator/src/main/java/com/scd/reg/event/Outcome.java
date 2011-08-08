package com.scd.reg.event;

import java.util.ArrayList;
import java.util.List;

public class Outcome {

	private String name;
	private List<Integer> values = new ArrayList<Integer>();

	public static Outcome newOutcome(String name) {
		Outcome outcome = new Outcome();
		outcome.setName(name);
		return outcome;
	}
	
	public Outcome addValue(int value) {
		getValues().add(value);
		return this;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getName()).append("-").append(getValuesString());
		return sb.toString();
	}
	
	public String getValuesString() {
		return getValues().toString();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String outcomeName) {
		this.name = outcomeName;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

}