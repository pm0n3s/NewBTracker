package com.NewBornTracker.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.NewBornTracker.model.abstracts.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("sleep")
public class Sleep extends EventType{

	@JsonFormat(pattern= "MM-dd-yyyy HH:mm", shape= JsonFormat.Shape.STRING)
	private LocalDateTime wakeup;
	
	public Sleep() {};
	
	public Sleep(LocalDateTime wakeup) {
		this.wakeup = wakeup.truncatedTo(ChronoUnit.MINUTES);
	}

	public LocalDateTime getWakeup() {
		return wakeup;
	}

	public void setWakeup(LocalDateTime wakeup) {
		this.wakeup = wakeup;
	}
}
