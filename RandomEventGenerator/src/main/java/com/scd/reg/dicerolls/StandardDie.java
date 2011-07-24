package com.scd.reg.dicerolls;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.events.PossibleOutcome;
import com.scd.reg.events.RandomEventGenerator;

@Component
public class StandardDie extends RandomEventGenerator {
	
	@PostConstruct
	public void init () {
		addEvent(new PossibleOutcome("One", 1));
		addEvent(new PossibleOutcome("Two", 2));
		addEvent(new PossibleOutcome("Three", 3));
		addEvent(new PossibleOutcome("Four", 4));
		addEvent(new PossibleOutcome("Five", 5));
		addEvent(new PossibleOutcome("Six", 6));
	}

	public PossibleOutcome roll() {
		return generateRandomEvent();
	}

	public List<PossibleOutcome> rolls(Integer rolls) {
		return generateRandomEvents(rolls);
	}

}
