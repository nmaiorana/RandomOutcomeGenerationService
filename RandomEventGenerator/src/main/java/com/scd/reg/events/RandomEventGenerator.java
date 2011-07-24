package com.scd.reg.events;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomEventGenerator {
	
	private String eventName = "Event";
	private List<PossibleOutcome> possibleOutcomes = new ArrayList<PossibleOutcome>();
	
	public void addEvent(PossibleOutcome possibleEvent) {
		getPossibleOutcomes().add(possibleEvent);
	}
	
	public void addEvents(List<PossibleOutcome> possibleEvents) {
		getPossibleOutcomes().addAll(possibleEvents);
	}
	
	public PossibleOutcome generateRandomEvent() {
		SecureRandom random = new SecureRandom(SecureRandom.getSeed(256));
		int randomEventIndex = random.nextInt(getPossibleOutcomes().size());
		return getPossibleOutcomes().get(randomEventIndex);
	}

	public List<PossibleOutcome> generateRandomEvents(Integer times) {
		int timesValue = 1;
		if (times != null) {
			timesValue = times;
		}
		List<PossibleOutcome> events = new ArrayList<PossibleOutcome>();
		for (int count=0; count < timesValue; count++) {
			events.add(generateRandomEvent());
		}
		return events;
	}

	public List<PossibleOutcome> getPossibleOutcomes() {
		return possibleOutcomes;
	}

	public void setPossibleOutcomes(List<PossibleOutcome> possibleOutcomes) {
		this.possibleOutcomes = possibleOutcomes;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}