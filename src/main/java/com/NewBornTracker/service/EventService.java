package com.NewBornTracker.service;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NewBornTracker.model.Event;
import com.NewBornTracker.model.User;

@Service
@Transactional
public class EventService {

	@Autowired
	private UserService userService;
	
	private static final AtomicLong counter = new AtomicLong();

	public void saveEvent(Long id, Event event) {
		System.out.println("made it to service");
		event.setId(counter.incrementAndGet());
		userService.getUserMap().get(id).setEvent(event);
	}

	public HashMap<Long, User> findAllEvents() {
		return null;
	}

	public Event findEventById(long userid, long eventid) {
		if (userService.getUserMap().containsKey(userid)) {
			User u = userService.findById(userid);
			for(Event e : u.getEventList()) {
				if(e.getId().equals(eventid)) {
					return e;
				}
			}
		}
		return null;
	}


	public void updateEvent(long id, Event event) {
		if (userService.getUserMap().containsKey(id)) {
			User u = userService.findById(id);
			for(int i=0; i<u.getEventList().size(); i++) {
				if(u.getEventList().get(i).getId().equals(event.getId())) {
					u.getEventList().set(i, event);
				}
			}
		}
	}

	public void deleteEventById(long userid, long eventid) {
		if (userService.getUserMap().containsKey(userid)) {
			User u = userService.findById(userid);
			Event ev = null;
			for(Event e : u.getEventList()) {
				if(e.getId().equals(eventid)) {
					ev = e;
					break;
				}
			}
			u.getEventList().remove(ev);
		}
	}

}
