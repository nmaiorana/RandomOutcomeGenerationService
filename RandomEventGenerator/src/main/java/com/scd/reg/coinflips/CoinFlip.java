package com.scd.reg.coinflips;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scd.reg.event.Event;
import com.scd.reg.event.EventOutcome;

@Component
public class CoinFlip extends Event {
	
	private static final String EVENT_NAME = "coinflip";
	
	@Autowired
	private StandardCoin standardCoin = new StandardCoin();
	
	@PostConstruct
	public void initPossibleOutcomes() {
		setPossibleOutcomes(getStandardCoin().getPossibleOutcomes());
	}
	
	@PostConstruct
	public void initEventName() {
		setEventName(EVENT_NAME);
	}
	
	public EventOutcome flip() {
		return doEvent();
	}

	public StandardCoin getStandardCoin() {
		return standardCoin;
	}

	public void setStandardCoin(StandardCoin standardCoin) {
		this.standardCoin = standardCoin;
	}

	public String getEventName() {
		return EVENT_NAME;
	}

}
