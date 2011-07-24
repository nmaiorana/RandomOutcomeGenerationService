package com.scd.reg.coinflips;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scd.reg.events.PossibleEvent;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CoinFlipController {
	
	private static final Logger logger = LoggerFactory.getLogger(CoinFlipController.class);
	
	@Autowired
	private StandardCoin standardCoin = new StandardCoin();
	
	/**
	 * Coin Flip Events.
	 */
	@RequestMapping(value = "/coinflip.do/flips/{flips}", method = RequestMethod.GET)
	public String coingFlips(@PathVariable Integer flips, Model model) {
		List<PossibleEvent> events = getStandardCoin().flips(flips);
		int value = 0;
		for(PossibleEvent event: events) {
			value += event.getEventValue();
		}
		model.addAttribute("eventType","coinflip");
		model.addAttribute("events",events);
		model.addAttribute("value",value);
		return "events";
	}

	@RequestMapping(value = "/coinflip.do", method = RequestMethod.GET)
	public String coinFlip() {
		return "forward:coinflip.do/flips/1";
	}
	
	public StandardCoin getStandardCoin() {
		return standardCoin;
	}

	public void setStandardCoin(StandardCoin standardCoin) {
		this.standardCoin = standardCoin;
	}

}
