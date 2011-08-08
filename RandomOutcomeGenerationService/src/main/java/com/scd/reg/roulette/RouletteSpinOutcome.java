package com.scd.reg.roulette;

import com.scd.reg.event.Outcome;
import com.scd.reg.roulette.RouletteColor;

public class RouletteSpinOutcome extends Outcome {
	
	public static Outcome newOutcome(String name) {
		Outcome outcome = new RouletteSpinOutcome();
		outcome.setName(name);
		return outcome;
	}
	
	@Override
	public String getValuesString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(getValues().get(0)).append(", ");
		int color = getValues().get(1);
		if (RouletteColor.GREEN.ordinal() == color) {
			sb.append("GREEN]");
		} else if (RouletteColor.BLACK.ordinal() == color) {
			sb.append("BLACK]");
		} else {
			sb.append("RED]");
		}
		return sb.toString();
		
	}

}
