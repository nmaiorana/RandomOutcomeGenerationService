package com.scd.reg.event;


public class EventOutcome {
	private String eventName;
	private PossibleOutcome outcome;
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getEventName()).append(": ").append(getOutcome());
		return sb.toString();
	}

	public PossibleOutcome getOutcome() {
		return outcome;
	}

	public void setOutcome(PossibleOutcome outcome) {
		this.outcome = outcome;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
