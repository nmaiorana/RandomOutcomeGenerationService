package com.scd.reg.dicerolls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scd.reg.event.Event;
import com.scd.reg.event.EventOutcome;

@Component
public class DieRoll extends Event {
	private static final String EVENT_DESC = "Die Roll";

	
	@Autowired
	private StandardDie standardDie = new StandardDie();
	
	public void initPossibleOutcomes() {
		setPossibleOutcomes(getStandardDie().getPossibleOutcomes());
	}
	
	public void initEventDescription() {
		setEventDescription(EVENT_DESC);
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
