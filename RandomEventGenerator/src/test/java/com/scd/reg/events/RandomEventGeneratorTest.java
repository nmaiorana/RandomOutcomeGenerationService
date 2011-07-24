package com.scd.reg.events;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.stat.Frequency;
import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.junit.Before;
import org.junit.Test;

public class RandomEventGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddEvent() {
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		eventGenerator.addEvent(new PossibleOutcome("Heads", 1));
		eventGenerator.addEvent(new PossibleOutcome("Tails", -1));
	}
	
	@Test
	public void testAddEvents() {
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		List<PossibleOutcome> possibleOutcomes = new ArrayList<PossibleOutcome>();
		possibleOutcomes.add(new PossibleOutcome("Heads", 1));
		possibleOutcomes.add(new PossibleOutcome("Tails", -1));
		eventGenerator.addEvents(possibleOutcomes);
	}

	@Test
	public void testGenerateRandomEvent() {
		Frequency frequency = new Frequency();
		Mean mean = new Mean();
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		List<PossibleOutcome> possibleOutcomes = new ArrayList<PossibleOutcome>();
		possibleOutcomes.add(new PossibleOutcome("Heads", 1));
		possibleOutcomes.add(new PossibleOutcome("Tails", -1));
		eventGenerator.setPossibleOutcomes(possibleOutcomes);
		for (int i=0; i<10; i++) {
			PossibleOutcome event = eventGenerator.generateRandomEvent();	
			frequency.addValue(event.getEventValue());
		}
		
		System.out.println(frequency.getPct(1));
		
	}

}
