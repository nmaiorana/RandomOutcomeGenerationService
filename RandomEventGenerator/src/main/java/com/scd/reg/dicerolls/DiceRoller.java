package com.scd.reg.dicerolls;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scd.reg.coinflips.StandardCoin;
import com.scd.reg.events.Event;
import com.scd.reg.events.PossibleOutcome;
import com.scd.reg.events.PossibleOutcomeSet;
import com.scd.reg.events.RandomEventGenerator;

@Component
public class DiceRoller extends RandomEventGenerator {
	private static final String EVENT_NAME = "diceroll";

	
	@Autowired
	private StandardDie standardDie = new StandardDie();

	public Event roll() {
		Event event = randomlySelectOutcome(getStandardDie());
		event.setName(EVENT_NAME);
		return event;
	}

	public List<Event> rolls(Integer rolls) {
		return randomlySelectOutcomes(EVENT_NAME, rolls, getStandardDie());
	}

	public List<Event> rolls(Integer numberOfDice, Integer rolls) {
		int numberOfDiceValue = 1;
		if (numberOfDice != null) {
			numberOfDiceValue = numberOfDice;
		}
		
		List<PossibleOutcomeSet> possibleOutcomeSets = new ArrayList<PossibleOutcomeSet>();
		for (int count=0; count < numberOfDiceValue; count++) {
			possibleOutcomeSets.add(getStandardDie());
		}
		return randomlySelectOutcomes(EVENT_NAME, rolls, possibleOutcomeSets);
	}

	public StandardDie getStandardDie() {
		return standardDie;
	}

	public void setStandardDie(StandardDie standardDie) {
		this.standardDie = standardDie;
	}

}
