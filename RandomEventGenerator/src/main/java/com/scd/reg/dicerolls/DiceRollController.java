package com.scd.reg.dicerolls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scd.reg.events.PossibleOutcome;
import com.scd.reg.events.RandomEventGenerator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DiceRollController {
	
	private static final Logger logger = LoggerFactory.getLogger(DiceRollController.class);
	
	@Autowired
	private StandardDie standardDie = new StandardDie();
	
	/**
	 * Die Roll Events.
	 */
	@RequestMapping(value = "/dieroll.do/rolls/{rolls}", method = RequestMethod.GET)
	public String dieRolls(@PathVariable Integer rolls, Model model) {
		List<PossibleOutcome> events = getStandardDie().rolls(rolls);
		int value = 0;
		for(PossibleOutcome event: events) {
			value += event.getEventValue();
		}
		model.addAttribute("eventType","dieroll");
		model.addAttribute("events",events);
		model.addAttribute("value",value);
		return "events";
	}

	@RequestMapping(value = "/dieroll.do", method = RequestMethod.GET)
	public String dieRole() {
		return "forward:dieroll.do/rolls/1";
	}

	public StandardDie getStandardDie() {
		return standardDie;
	}

	public void setStandardDie(StandardDie standardDie) {
		this.standardDie = standardDie;
	}

	
}
