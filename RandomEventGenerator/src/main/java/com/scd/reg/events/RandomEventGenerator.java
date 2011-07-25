package com.scd.reg.events;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RandomEventGenerator {

	public Event randomlySelectOutcome(PossibleOutcomeSet possibleOutcomeSet) {
		List<PossibleOutcomeSet> possibleOutcomeSets = new ArrayList<PossibleOutcomeSet>();
		possibleOutcomeSets.add(possibleOutcomeSet);
		return randomlySelectOutcome(possibleOutcomeSet);
	}

	public Event randomlySelectOutcome(List<PossibleOutcomeSet> possibleOutcomeSets) {
		SecureRandom random = new SecureRandom(SecureRandom.getSeed(256));
		Event event = new Event();
		for (PossibleOutcomeSet possibleOutcomeSet : possibleOutcomeSets) {
			int randomEventIndex = random.nextInt(possibleOutcomeSet.getPossibleOutcomes().size());
			event.addOutcome(possibleOutcomeSet.getPossibleOutcomes().get(randomEventIndex));
		}
		return event;
	}

	public List<Event> randomlySelectOutcomes(String eventName, Integer times, PossibleOutcomeSet possibleOutcomeSet) {
		List<PossibleOutcomeSet> possibleOutcomeSets = new ArrayList<PossibleOutcomeSet>();
		possibleOutcomeSets.add(possibleOutcomeSet);
		return randomlySelectOutcomes(eventName, times, possibleOutcomeSets);
	}

	public List<Event> randomlySelectOutcomes(String eventName, Integer times, List<PossibleOutcomeSet> possibleOutcomeSets) {
		int timesValue = 1;
		if (times != null) {
			timesValue = times;
		}
		List<Event> events = new ArrayList<Event>();
		for (int count = 0; count < timesValue; count++) {
			Event event = randomlySelectOutcome(possibleOutcomeSets);
			event.setName(eventName);
			events.add(event);
		}
		return events;
	}

}