package com.scd.reg.coinflips;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.event.Outcome;
import com.scd.reg.event.PossibleOutcomeSet;

@Component
public class StandardCoin extends PossibleOutcomeSet {
	
	@PostConstruct
	public void init () {
		addPossibleOutcome(Outcome.newOutcome("Heads").addValue(1));
		addPossibleOutcome(Outcome.newOutcome("Tails").addValue(-1));
	}
	
}
