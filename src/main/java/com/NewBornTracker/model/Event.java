package com.NewBornTracker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.NewBornTracker.model.abstracts.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Event {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
	
	private Long Id;
	@JsonFormat(pattern= "MM-dd-yyyy HH:mm", shape= JsonFormat.Shape.STRING)
	private LocalDateTime time;
	private EventType type;
	private String notes;
	
	public Event() {};
	
	public Event(Long id, LocalDateTime time, EventType type, String notes) {
		super();
		Id = id;
		this.time = time.truncatedTo(ChronoUnit.MINUTES);
		this.type = type;
		this.notes = notes;
	}
	
	public Event(Long id, String time, EventType type, String notes) {
		super();
		Id = id;
		this.time = LocalDateTime.parse(time, FORMATTER);
		this.type = type;
		this.notes = notes;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}
}
