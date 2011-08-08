package com.scd.reg.roulette;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.scd.reg.event.Outcome;
import com.scd.reg.event.PossibleOutcomeSet;

@Component
public class RouletteWheelSingleZero extends PossibleOutcomeSet {
	
	/**
	 * In number ranges from 1 to 10 and 19 to 28, odd numbers are red and even are black. In ranges from 11 to 18 and 29 to 36, 
	 * odd numbers are black and even are red.
	 * There is a green pocket numbered 0 (zero). In American roulette, there is a second green pocket marked 00. Pocket number
	 * order on the roulette wheel adheres to the following clockwise sequence in most casinos:[citation needed]
	 * Single-zero wheel
	 * 		0-32-15-19-4-21-2-25-17-34-6-27-13-36-11-30-8-23-10-5-24-16-33-1-20-14-31-9-22-18-29-7-28-12-35-3-26
	 */

	@PostConstruct
	public void init() {
		addPossibleOutcome(RouletteSpinOutcome.newOutcome("0:Green").addValue(0).addValue(RouletteColor.GREEN.ordinal()));
		for (int number=1; number<= 10; number++) {
			if (number % 2 !=0) {
				// Odd numbers
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Red").addValue(number).addValue(RouletteColor.RED.ordinal()));				
			} else {
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Black").addValue(number).addValue(RouletteColor.BLACK.ordinal()));								
			}
		}
		for (int number=11; number<= 18; number++) {
			if (number % 2 !=0) {
				// Odd numbers
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Black").addValue(number).addValue(RouletteColor.BLACK.ordinal()));								
			} else {
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Red").addValue(number).addValue(RouletteColor.RED.ordinal()));				
			}
		}
		for (int number=19; number<= 28; number++) {
			if (number % 2 !=0) {
				// Odd numbers
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Red").addValue(number).addValue(RouletteColor.RED.ordinal()));				
			} else {
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Black").addValue(number).addValue(RouletteColor.BLACK.ordinal()));								
			}
		}
		for (int number=29; number<= 36; number++) {
			if (number % 2 !=0) {
				// Odd numbers
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Black").addValue(number).addValue(RouletteColor.BLACK.ordinal()));								
			} else {
				addPossibleOutcome(RouletteSpinOutcome.newOutcome(number+":Red").addValue(number).addValue(RouletteColor.RED.ordinal()));				
			}
		}

	}

}
