package com.scd.reg.coinflips;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scd.reg.events.Event;
import com.scd.reg.events.RandomEventGenerator;

@Component
public class CoinFlipper extends RandomEventGenerator {
	
	private static final String EVENT_NAME = "coinflip";
	
	@Autowired
	private StandardCoin standardCoin = new StandardCoin();
	
	public Event flip() {
		Event event = randomlySelectOutcome(getStandardCoin());
		event.setName(EVENT_NAME);
		return event;
	}

	public List<Event> flips(Integer flips) {
		return randomlySelectOutcomes(EVENT_NAME, flips, getStandardCoin());
	}

	public StandardCoin getStandardCoin() {
		return standardCoin;
	}

	public void setStandardCoin(StandardCoin standardCoin) {
		this.standardCoin = standardCoin;
	}

}
