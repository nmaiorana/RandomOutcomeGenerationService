package com.scd.reg.roulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scd.reg.event.Event;
import com.scd.reg.event.EventOutcome;

@Component
public class SingleZeroRouletteWheelSpin extends Event {
	private static final String EVENT_DESC = "Roulette Wheel Spin";

	
	@Autowired
	private RouletteWheelSingleZero rouletteWheelSingleZero = new RouletteWheelSingleZero();
	
	public void initPossibleOutcomes() {
		setPossibleOutcomes(getRouletteWheelSingleZero().getPossibleOutcomes());
	}
	
	public void initEventDescription() {
		setEventDescription(EVENT_DESC);
	}

	
	public EventOutcome roll() {
		return doEvent();
	}

	public RouletteWheelSingleZero getRouletteWheelSingleZero() {
		return rouletteWheelSingleZero;
	}

	public void setRouletteWheelSingleZero(RouletteWheelSingleZero rouletteWheelSingleZero) {
		this.rouletteWheelSingleZero = rouletteWheelSingleZero;
	}

}
