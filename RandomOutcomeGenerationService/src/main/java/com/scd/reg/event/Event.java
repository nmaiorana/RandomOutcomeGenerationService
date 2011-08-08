package com.scd.reg.event;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
abstract public class Event implements BeanNameAware {
	private String eventName = new String();
	private String eventDescription = new String();
	private List<Outcome> possibleOutcomes = new ArrayList<Outcome>();

	@PostConstruct
	abstract public void initPossibleOutcomes();

	@PostConstruct
	abstract public void initEventDescription();

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getEventName()).append(": ").append(getPossibleOutcomes());
		return sb.toString();
	}
	
	public EventOutcome doEvent() {
		SecureRandom random = new SecureRandom(SecureRandom.getSeed(256));
		int randomEventIndex = random.nextInt(getPossibleOutcomes().size());
		EventOutcome outcome = new EventOutcome();
		outcome.setEventName(getEventName());
		outcome.setOutcome(getPossibleOutcomes().get(randomEventIndex));
		return outcome;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public List<Outcome> getPossibleOutcomes() {
		return possibleOutcomes;
	}

	public void setPossibleOutcomes(List<Outcome> possibleOutcomes) {
		this.possibleOutcomes = possibleOutcomes;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	public void setBeanName(String name) {
		setEventName(name);
	}

}