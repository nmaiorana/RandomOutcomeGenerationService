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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scd.reg.event.Event;
import com.scd.reg.event.EventOutcome;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RandomOutcomeController implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	private static final Logger logger = LoggerFactory.getLogger(RandomOutcomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Random Event Generator Service: The client locale is "+ locale.toString());
		return "home";
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public String events(Locale locale, Model model) {
		Map<String, Event> eventTypes = (Map<String, Event>) getApplicationContext().getBeansOfType(Event.class);
		logger.info("Events: "+eventTypes.values());
		model.addAttribute("events",eventTypes.values());
		return "eventslist";
	}

	@RequestMapping(value = "/event/{eventName}", method = RequestMethod.GET)
	public String event(@PathVariable String eventName, Locale locale, Model model) {
		Map<String, Event> eventTypes = (Map<String, Event>) getApplicationContext().getBeansOfType(Event.class);
		Event event = eventTypes.get(eventName);
		if (event == null) return "event";
		EventOutcome outcome = event.doEvent();
		logger.info("Event: "+outcome);
		model.addAttribute("event",outcome);
		return "event";
	}
	
	@RequestMapping(value = "/event/{eventName}/times/{times}", method = RequestMethod.GET)
	public String multiEvent(@PathVariable String eventName, @PathVariable int times, Model model) {
		Map<String, Event> eventTypes = (Map<String, Event>) getApplicationContext().getBeansOfType(Event.class);
		Event event = eventTypes.get(eventName);
		if (event == null) return "event";
		List<EventOutcome> outcomes = new ArrayList<EventOutcome>();
		for(int time=0; time<times; time++) {
			outcomes.add(event.doEvent());
		}
		logger.info("Events: "+outcomes);
		model.addAttribute("events",outcomes);
		return "events";
	}


	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
}
