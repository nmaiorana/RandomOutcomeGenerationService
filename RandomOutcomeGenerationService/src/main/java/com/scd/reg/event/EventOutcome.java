package com.scd.reg.event;


public class EventOutcome {
	private String eventName;
	private Outcome outcome;
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getEventName()).append(": ").append(getOutcome());
		return sb.toString();
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
