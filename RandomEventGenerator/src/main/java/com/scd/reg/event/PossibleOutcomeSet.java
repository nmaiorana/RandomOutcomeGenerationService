package com.scd.reg.event;

import java.util.ArrayList;
import java.util.List;

public class PossibleOutcomeSet {
	private List<Outcome> possibleOutcomes = new ArrayList<Outcome>();
	
	public String toString() {
		return getPossibleOutcomes().toString();
	}
	
	public void addPossibleOutcome(Outcome possibleOutcome) {
		getPossibleOutcomes().add(possibleOutcome);
	}

	public List<Outcome> getPossibleOutcomes() {
		return possibleOutcomes;
	}

	public void setPossibleOutcomes(List<Outcome> possibleOutcomes) {
		this.possibleOutcomes = possibleOutcomes;
	}

}
