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

import com.scd.reg.events.Event;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CoinFlipController {
	
	private static final Logger logger = LoggerFactory.getLogger(CoinFlipController.class);
	
	@Autowired
	private CoinFlipper coinFlipper = new CoinFlipper();
	
	/**
	 * Coin Flip Events.
	 */
	@RequestMapping(value = "/coinflip.do/flips/{flips}", method = RequestMethod.GET)
	public String coingFlips(@PathVariable Integer flips, Model model) {
		List<Event> events = getCoinFlipper().flips(flips);
		model.addAttribute("events",events);
		return "events";
	}

	@RequestMapping(value = "/coinflip.do", method = RequestMethod.GET)
	public String coinFlip() {
		return "forward:coinflip.do/flips/1";
	}

	public CoinFlipper getCoinFlipper() {
		return coinFlipper;
	}

	public void setCoinFlipper(CoinFlipper coinFlipper) {
		this.coinFlipper = coinFlipper;
	}

}
