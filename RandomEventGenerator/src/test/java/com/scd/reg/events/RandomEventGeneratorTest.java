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
	public void testRandomlySelectOutcome() {
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		PossibleOutcomeSet possibleOutcomeSet = new PossibleOutcomeSet();
		possibleOutcomeSet.addPossibleOutcome(new PossibleOutcome("Heads", 1));
		possibleOutcomeSet.addPossibleOutcome(new PossibleOutcome("Tails", -1));
		List<PossibleOutcomeSet> possibleOutcomeSets = new ArrayList<PossibleOutcomeSet>();
		possibleOutcomeSets.add(possibleOutcomeSet);
		eventGenerator.randomlySelectOutcome(possibleOutcomeSets);
	}
	

	@Test
	public void testRandomlySelectOutcomeStatistics() {
		Frequency frequency = new Frequency();
		RandomEventGenerator eventGenerator = new RandomEventGenerator();
		PossibleOutcomeSet possibleOutcomeSet = new PossibleOutcomeSet();
		possibleOutcomeSet.addPossibleOutcome(new PossibleOutcome("Heads", 1));
		possibleOutcomeSet.addPossibleOutcome(new PossibleOutcome("Tails", -1));
		List<PossibleOutcomeSet> possibleOutcomeSets = new ArrayList<PossibleOutcomeSet>();
		possibleOutcomeSets.add(possibleOutcomeSet);
		for (int i=0; i<10; i++) {
			Event event = eventGenerator.randomlySelectOutcome(possibleOutcomeSets);	
			frequency.addValue(event.getOutcomes().get(0).getValue());
		}
		
		System.out.println("Fequency: "+ frequency.getPct(1));
		
	}

}
