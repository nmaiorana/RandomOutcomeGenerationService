package com.scd.reg.coinflips;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.events.PossibleEvent;
import com.scd.reg.events.RandomEventGenerator;

@Component
public class StandardCoin extends RandomEventGenerator {

	@PostConstruct
	public void init () {
		addEvent(new PossibleEvent("Heads", 1));
		addEvent(new PossibleEvent("Tails", -1));
	}
	
	public PossibleEvent flip() {
		return generateRandomEvent();
	}

	public List<PossibleEvent> flips(Integer flips) {
		return generateRandomEvents(flips);
	}

}
