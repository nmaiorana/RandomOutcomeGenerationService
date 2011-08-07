package com.scd.reg.coinflips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scd.reg.event.Event;
import com.scd.reg.event.EventOutcome;

@Component
public class CoinFlip extends Event {
	
	private static final String EVENT_NAME = "coinflip";
	private static final String EVENT_DESC = "Coin Flip";
	
	@Autowired
	private StandardCoin standardCoin = new StandardCoin();
	
	public void initPossibleOutcomes() {
		setPossibleOutcomes(getStandardCoin().getPossibleOutcomes());
	}
	
	public void initEventDescription() {
		setEventDescription(EVENT_DESC);
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

}
