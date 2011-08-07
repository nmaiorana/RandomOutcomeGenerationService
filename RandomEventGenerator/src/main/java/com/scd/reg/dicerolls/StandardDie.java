package com.scd.reg.dicerolls;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.event.PossibleOutcome;
import com.scd.reg.event.PossibleOutcomeSet;

@Component
public class StandardDie extends PossibleOutcomeSet {
	
	@PostConstruct
	public void init () {
		addPossibleOutcome(new PossibleOutcome("One", 1));
		addPossibleOutcome(new PossibleOutcome("Two", 2));
		addPossibleOutcome(new PossibleOutcome("Three", 3));
		addPossibleOutcome(new PossibleOutcome("Four", 4));
		addPossibleOutcome(new PossibleOutcome("Five", 5));
		addPossibleOutcome(new PossibleOutcome("Six", 6));
	}

}
