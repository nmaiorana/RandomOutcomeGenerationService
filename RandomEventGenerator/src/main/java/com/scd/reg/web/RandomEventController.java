package com.scd.reg.web;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
}
