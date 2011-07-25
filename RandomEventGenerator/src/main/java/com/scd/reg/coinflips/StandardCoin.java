package com.scd.reg.coinflips;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.events.PossibleOutcome;
import com.scd.reg.events.PossibleOutcomeSet;

@Component
public class StandardCoin extends PossibleOutcomeSet {
	
	@PostConstruct
	public void init () {
		addPossibleOutcome(new PossibleOutcome("Heads", 1));
		addPossibleOutcome(new PossibleOutcome("Tails", -1));
	}
	
}
