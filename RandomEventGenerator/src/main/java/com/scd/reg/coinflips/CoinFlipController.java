package com.scd.reg.coinflips;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scd.reg.event.Event;
import com.scd.reg.event.EventOutcome;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CoinFlipController {
	
	private static final Logger logger = LoggerFactory.getLogger(CoinFlipController.class);
	
	@Autowired
	private CoinFlip coinFlip = new CoinFlip();
	
	/**
	 * Coin Flip Events.
	 */
	@RequestMapping(value = "/coinflip.do/flips/{flips}", method = RequestMethod.GET)
	public String coingFlips(@PathVariable Integer flips, Model model) {
//		List<EventOutcome> events = getCoinFlip().flips(flips);
//		model.addAttribute("events",events);
		return "outcomes";
	}

	@RequestMapping(value = "/coinflip.do", method = RequestMethod.GET)
	public String coinFlip(Model model) {
		EventOutcome outcome = getCoinFlip().doEvent();
		model.addAttribute("event", outcome);		
		return "event";
	}

	public CoinFlip getCoinFlip() {
		return coinFlip;
	}

	public void setCoinFlip(CoinFlip coinFlip) {
		this.coinFlip = coinFlip;
	}

}
