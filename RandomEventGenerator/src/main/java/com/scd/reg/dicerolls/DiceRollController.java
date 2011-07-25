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

import com.scd.reg.events.Event;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DiceRollController {
	
	private static final Logger logger = LoggerFactory.getLogger(DiceRollController.class);
	
	@Autowired
	private DiceRoller diceRoller = new DiceRoller();
	
	/**
	 * Die Roll Events.
	 */
	@RequestMapping(value = "/dieroll.do/dice/{diceCount}/rolls/{rolls}", method = RequestMethod.GET)
	public String diceRolls(@PathVariable Integer diceCount, @PathVariable Integer rolls, Model model) {
		List<Event> events = getDiceRoller().rolls(diceCount, rolls);
		model.addAttribute("events",events);
		return "events";
	}

	@RequestMapping(value = "/dieroll.do/rolls/{rolls}", method = RequestMethod.GET)
	public String dieRolls(@PathVariable Integer rolls, Model model) {
		List<Event> events = getDiceRoller().rolls(rolls);
		model.addAttribute("events",events);
		return "events";
	}

	@RequestMapping(value = "/dieroll.do", method = RequestMethod.GET)
	public String dieRole() {
		return "forward:dieroll.do/rolls/1";
	}

	public DiceRoller getDiceRoller() {
		return diceRoller;
	}

	public void setDiceRoller(DiceRoller diceRoller) {
		this.diceRoller = diceRoller;
	}

	
}
