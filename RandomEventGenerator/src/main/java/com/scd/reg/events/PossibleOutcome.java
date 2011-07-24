package com.scd.reg.events;


public class PossibleOutcome {

	private String eventName;
	private int eventValue;
	
	public PossibleOutcome(String eventName, int value) {
		this.setEventName(eventName);
		this.setEventValue(value);
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
