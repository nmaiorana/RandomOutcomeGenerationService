package com.scd.reg.event;

import java.util.ArrayList;
import java.util.List;

public class PossibleOutcomeSet {
	private List<PossibleOutcome> possibleOutcomes = new ArrayList<PossibleOutcome>();
	
	public String toString() {
		return getPossibleOutcomes().toString();
	}
	
	public void addPossibleOutcome(PossibleOutcome possibleOutcome) {
		getPossibleOutcomes().add(possibleOutcome);
	}

	public List<PossibleOutcome> getPossibleOutcomes() {
		return possibleOutcomes;
	}

	public void setPossibleOutcomes(List<PossibleOutcome> possibleOutcomes) {
		this.possibleOutcomes = possibleOutcomes;
	}

}
