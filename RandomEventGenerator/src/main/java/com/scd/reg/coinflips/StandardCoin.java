package com.scd.reg.coinflips;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.event.PossibleOutcome;
import com.scd.reg.event.PossibleOutcomeSet;

@Component
public class StandardCoin extends PossibleOutcomeSet {
	
	@PostConstruct
	public void init () {
		addPossibleOutcome(new PossibleOutcome("Heads", 1));
		addPossibleOutcome(new PossibleOutcome("Tails", -1));
	}
	
}
