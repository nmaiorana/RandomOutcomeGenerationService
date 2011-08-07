package com.scd.reg.event;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
abstract public class Event {
	private String eventName = new String();
	private List<PossibleOutcome> possibleOutcomes = new ArrayList<PossibleOutcome>();

	@PostConstruct
	abstract public void initPossibleOutcomes();

	@PostConstruct
	abstract public void initEventName();

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getEventName()).append(": ").append(getPossibleOutcomes());
		return sb.toString();
	}
	
	public EventOutcome doEvent() {
		SecureRandom random = new SecureRandom(SecureRandom.getSeed(256));
		int randomEventIndex = random.nextInt(getPossibleOutcomes().size());
		EventOutcome outcome = new EventOutcome();
		outcome.setEventName(getEventName());
		outcome.setOutcome(getPossibleOutcomes().get(randomEventIndex));
		return outcome;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public List<PossibleOutcome> getPossibleOutcomes() {
		return possibleOutcomes;
	}

	public void setPossibleOutcomes(List<PossibleOutcome> possibleOutcomes) {
		this.possibleOutcomes = possibleOutcomes;
	}

}