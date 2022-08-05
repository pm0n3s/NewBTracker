package com.NewBornTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NewBornTracker.dao.EventDao;
import com.NewBornTracker.model.Event;
import com.NewBornTracker.model.abstracts.EventType;

@Service
@Transactional
public class EventService {
	
	@Autowired
	private EventDao eventDao;

	public List<Event> findAllEvents() {
		return eventDao.findAllEvents();
	}

	public Event findEventById(long eventid) {
		return  eventDao.findById(eventid);
	}

	public EventType saveEventType(EventType type) {
		return eventDao.saveEventType(type);
	}

	public void saveEvent(long id, Event event, EventType et) {
		eventDao.save(id, event, et);
	}

	public Event updateEvent(Event event) {

		Event currentEvent = findEventById(event.getId());
		
		updateEventType(event.getType());
		
		currentEvent.setTime(event.getTime());
		currentEvent.setNotes(event.getNotes());

		eventDao.update(currentEvent);
		return currentEvent;
	}

	public void deleteEventById(long userid, long eventid) {
		eventDao.delete(eventid);
	}

	public EventType findEventTypeById(Long id) {
		return eventDao.findEventTypeById(id);
	}

	public void updateEventType(EventType et) {
		eventDao.updateEventType(et);
	}

}
