package com.scd.reg.events;

import java.util.ArrayList;
import java.util.List;

public class PossibleEvent {

	private String eventName;
	private int eventValue;
	
	public PossibleEvent(String eventName, int value) {
		this.setEventName(eventName);
		this.setEventValue(value);
	}
	
	public static List<PossibleEvent> coinFlip() {
		List<PossibleEvent> possibleEvents = new ArrayList<PossibleEvent>();
		possibleEvents.add(new PossibleEvent("Heads", 1));
		possibleEvents.add(new PossibleEvent("Tails", -1));
		return possibleEvents;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getEventName()).append("-").append(getEventValue());
		return sb.toString();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getEventValue() {
		return eventValue;
	}

	public void setEventValue(int eventValue) {
		this.eventValue = eventValue;
	}

}
