package com.scd.reg.events;

import java.util.ArrayList;
import java.util.List;

public class PossibleOutcomeSet {
	private List<PossibleOutcome> possibleOutcomes = new ArrayList<PossibleOutcome>();
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (PossibleOutcome possibleOutcome: getPossibleOutcomes()) {
			sb.append("[").append(possibleOutcome).append("]");
		}
		return sb.toString();
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
