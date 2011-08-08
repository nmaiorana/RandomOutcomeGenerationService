package com.scd.reg.dicerolls;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.event.Outcome;
import com.scd.reg.event.PossibleOutcomeSet;

@Component
public class StandardDie extends PossibleOutcomeSet {
	
	@PostConstruct
	public void init () {
		addPossibleOutcome(Outcome.newOutcome("1").addValue(1));
		addPossibleOutcome(Outcome.newOutcome("2").addValue(2));
		addPossibleOutcome(Outcome.newOutcome("3").addValue(3));
		addPossibleOutcome(Outcome.newOutcome("4").addValue(4));
		addPossibleOutcome(Outcome.newOutcome("5").addValue(5));
		addPossibleOutcome(Outcome.newOutcome("6").addValue(6));
	}

}
