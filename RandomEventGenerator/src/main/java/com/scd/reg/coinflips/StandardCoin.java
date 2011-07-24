package com.scd.reg.coinflips;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.events.PossibleOutcome;
import com.scd.reg.events.RandomEventGenerator;

@Component
public class StandardCoin extends RandomEventGenerator {

	@PostConstruct
	public void init () {
		addEvent(new PossibleOutcome("Heads", 1));
		addEvent(new PossibleOutcome("Tails", -1));
	}
	
	public PossibleOutcome flip() {
		return generateRandomEvent();
	}

	public List<PossibleOutcome> flips(Integer flips) {
		return generateRandomEvents(flips);
	}

}
