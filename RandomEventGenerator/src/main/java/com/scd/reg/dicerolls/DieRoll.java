package com.scd.reg.dicerolls;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scd.reg.event.Event;
import com.scd.reg.event.EventOutcome;

@Component
public class DieRoll extends Event {
	private static final String EVENT_NAME = "dieroll";

	
	@Autowired
	private StandardDie standardDie = new StandardDie();
	
	@PostConstruct
	public void initPossibleOutcomes() {
		setPossibleOutcomes(getStandardDie().getPossibleOutcomes());
	}
	
	@PostConstruct
	public void initEventName() {
		setEventName(EVENT_NAME);
	}
	
	public EventOutcome roll() {
		return doEvent();
	}

	public StandardDie getStandardDie() {
		return standardDie;
	}

	public void setStandardDie(StandardDie standardDie) {
		this.standardDie = standardDie;
	}

}
