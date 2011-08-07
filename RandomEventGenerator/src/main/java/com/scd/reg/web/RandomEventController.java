package com.scd.reg.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scd.reg.event.Event;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RandomEventController implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	private static final Logger logger = LoggerFactory.getLogger(RandomEventController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Random Event Generator Service: The client locale is "+ locale.toString());
		return "home";
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public String event(Locale locale, Model model) {
		Map eventTypes = getApplicationContext().getBeansOfType(Event.class);
		List<String> eventNames = new ArrayList<String>();
		for(Object eventName: eventTypes.keySet()) {
			eventNames.add((String) eventName);
		}
		logger.info("Events: "+eventNames);
		model.addAttribute("events",eventNames);
		return "events";
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
}
