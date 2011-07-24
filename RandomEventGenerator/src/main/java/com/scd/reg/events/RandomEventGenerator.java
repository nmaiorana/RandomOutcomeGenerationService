package com.scd.reg.events;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomEventGenerator {
	
	private List<PossibleEvent> possibleEvents = new ArrayList<PossibleEvent>();
	
	public void addEvent(PossibleEvent possibleEvent) {
		getPossibleEvents().add(possibleEvent);
	}
	
	public void addEvents(List<PossibleEvent> possibleEvents) {
		getPossibleEvents().addAll(possibleEvents);
	}
	
	public PossibleEvent generateRandomEvent() {
		SecureRandom random = new SecureRandom(SecureRandom.getSeed(256));
		int randomEventIndex = random.nextInt(getPossibleEvents().size());
		return getPossibleEvents().get(randomEventIndex);
	}

	public List<PossibleEvent> generateRandomEvents(Integer times) {
		int timesValue = 1;
		if (times != null) {
			timesValue = times;
		}
		List<PossibleEvent> events = new ArrayList<PossibleEvent>();
		for (int count=0; count < timesValue; count++) {
			events.add(generateRandomEvent());
		}
		return events;
	}

	public List<PossibleEvent> getPossibleEvents() {
		return possibleEvents;
	}

	public void setPossibleEvents(List<PossibleEvent> possibleEvents) {
		this.possibleEvents = possibleEvents;
	}

	public static List<PossibleEvent> dieRolls(Integer times) {
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		eventGenerator.addEvent(new PossibleEvent("One", 1));
		eventGenerator.addEvent(new PossibleEvent("Two", 2));
		eventGenerator.addEvent(new PossibleEvent("Three", 3));
		eventGenerator.addEvent(new PossibleEvent("Four", 4));
		eventGenerator.addEvent(new PossibleEvent("Five", 5));
		eventGenerator.addEvent(new PossibleEvent("Six", 6));
		return eventGenerator.generateRandomEvents(times);
	}

}