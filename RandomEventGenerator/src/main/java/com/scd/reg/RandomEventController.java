package com.scd.reg;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RandomEventController {
	
	private static final Logger logger = LoggerFactory.getLogger(RandomEventController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Random Event Generator Service: The client locale is "+ locale.toString());
		return "home";
	}
	
	/**
	 * Coin Flip Events.
	 */
	@RequestMapping(value = "/coinflip.do/{times}", method = RequestMethod.GET)
	public String coingFlips(@PathVariable Integer times, Model model) {
		List<PossibleEvent> events = RandomEventGenerator.coinFlips(times);
		model.addAttribute("eventType","coinflip");
		model.addAttribute("events",events);
		logger.info("Coin Flips: "+ events);
		return "events";
	}

	@RequestMapping(value = "/coinflip.do", method = RequestMethod.GET)
	public String coingFlip(Model model) {
		List<PossibleEvent> events = RandomEventGenerator.coinFlips(1);
		model.addAttribute("eventType","coinflip");
		model.addAttribute("events", events);
		logger.info("Coin Flips: "+ events);
		return "events";
	}

	/**
	 * Die Roll Events.
	 */
	@RequestMapping(value = "/dieroll.do/{times}", method = RequestMethod.GET)
	public String dieRolls(@PathVariable Integer times, Model model) {
		List<PossibleEvent> events = RandomEventGenerator.dieRolls(times);
		model.addAttribute("eventType","dieroll");
		model.addAttribute("events",events);
		logger.info("Die Roles: "+ events);
		return "events";
	}

	@RequestMapping(value = "/dieroll.do", method = RequestMethod.GET)
	public String dieRole(Model model) {
		List<PossibleEvent> events = RandomEventGenerator.dieRolls(1);
		model.addAttribute("eventType","dieroll");
		model.addAttribute("events", events);
		logger.info("Die Roles: "+ events);
		return "events";
	}

	
}
