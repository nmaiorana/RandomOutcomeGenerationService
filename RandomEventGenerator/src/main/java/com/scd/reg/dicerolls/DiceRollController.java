package com.scd.reg.dicerolls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scd.reg.event.EventOutcome;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DiceRollController {
	
	private static final Logger logger = LoggerFactory.getLogger(DiceRollController.class);
	
	@Autowired
	private DieRoll dieRoll = new DieRoll();
	
	/**
	 * Die Roll Events.
	 */
	@RequestMapping(value = "/dieroll.do/dice/{diceCount}/rolls/{rolls}", method = RequestMethod.GET)
	public String diceRolls(@PathVariable Integer diceCount, @PathVariable Integer rolls, Model model) {
//		List<EventOutcome> events = getDiceRoller().rolls(diceCount, rolls);
//		model.addAttribute("events",events);
		return "outcomes";
	}

	@RequestMapping(value = "/dieroll.do/rolls/{rolls}", method = RequestMethod.GET)
	public String dieRolls(@PathVariable Integer rolls, Model model) {
//		List<EventOutcome> events = getDiceRoller().rolls(rolls);
//		model.addAttribute("events",events);
		return "event";
	}

	@RequestMapping(value = "/dieroll.do", method = RequestMethod.GET)
	public String dieRole(Model model) {
		EventOutcome outcome = getDieRoll().doEvent();
		model.addAttribute("event", outcome);		
		return "event";
	}

	public DieRoll getDieRoll() {
		return dieRoll;
	}

	public void setDieRoll(DieRoll dieRoll) {
		this.dieRoll = dieRoll;
	}

	
}
