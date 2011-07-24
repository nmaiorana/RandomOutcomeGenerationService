package com.scd.reg.dicerolls;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.events.PossibleEvent;
import com.scd.reg.events.RandomEventGenerator;

@Component
public class StandardDie extends RandomEventGenerator {
	
	@PostConstruct
	public void init () {
		addEvent(new PossibleEvent("One", 1));
		addEvent(new PossibleEvent("Two", 2));
		addEvent(new PossibleEvent("Three", 3));
		addEvent(new PossibleEvent("Four", 4));
		addEvent(new PossibleEvent("Five", 5));
		addEvent(new PossibleEvent("Six", 6));
	}

	public PossibleEvent roll() {
		return generateRandomEvent();
	}

	public List<PossibleEvent> rolls(Integer rolls) {
		return generateRandomEvents(rolls);
	}

}
