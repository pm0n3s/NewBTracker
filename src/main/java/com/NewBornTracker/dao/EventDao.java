package com.NewBornTracker.dao;

import java.util.List;

import com.NewBornTracker.model.Event;
import com.NewBornTracker.model.abstracts.EventType;

public interface EventDao {
	
	Event findById(Long id);
	
	void save(long id, Event event, EventType et);
	
	void delete(Long id);
	
	List<Event> findAllEvents();

	EventType saveEventType(EventType type);

	void update(Event event);

	EventType findEventTypeById(Long id);

	void updateEventType(EventType et);

}
