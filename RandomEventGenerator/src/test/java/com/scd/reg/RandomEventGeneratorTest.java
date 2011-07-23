package com.scd.reg;

import org.apache.commons.math.stat.Frequency;
import org.apache.commons.math.stat.StatUtils;
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
		for(PossibleEvent possibleEvent: PossibleEvent.coinFlip()) {
			eventGenerator.addEvent(possibleEvent);
		}
		PossibleEvent event = eventGenerator.generateRandomEvent();
	}
	
	@Test
	public void testAddEvents() {
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		eventGenerator.addEvents(PossibleEvent.coinFlip());
		PossibleEvent event = eventGenerator.generateRandomEvent();
	}

	@Test
	public void testGenerateRandomEvent() {
		Frequency frequency = new Frequency();
		Mean mean = new Mean();
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		eventGenerator.setPossibleEvents(PossibleEvent.coinFlip());
		for (int i=0; i<10; i++) {
			PossibleEvent event = eventGenerator.generateRandomEvent();	
			frequency.addValue(event.getEventValue());
		}
		
		System.out.println(frequency.getPct(1));
		
	}


	@Test
	public void testSetPossibleEvents() {
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		eventGenerator.setPossibleEvents(PossibleEvent.coinFlip());
		PossibleEvent event = eventGenerator.generateRandomEvent();
	}

}
