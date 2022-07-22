package com.NewBornTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.NewBornTracker.model.Event;
import com.NewBornTracker.model.User;
import com.NewBornTracker.service.EventService;
import com.NewBornTracker.service.UserService;

@RestController
@RequestMapping("events")
public class EventController {

	@Autowired
	private UserService userService;

	@Autowired
	private EventService eventService;

	// read user
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createEvent(@PathVariable("id") long id, @RequestBody Event event,
			UriComponentsBuilder ucBuilder) {
		System.out.println("made it inside controller");

		if (userService.isUserExist(id)) {
			System.out.println("made it inside controller method");
			System.out.println("Creating Event " + event.getType());
			eventService.saveEvent(id, event);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/{id}/{eventId}")
	public ResponseEntity<Event> updateUser(@PathVariable("id") long id, @PathVariable("eventId") long eventId,
			@RequestBody Event event) {
		System.out.println("Updating Event " + eventId);

		Event currentEvent = eventService.findEventById(id, eventId);

		if (currentEvent == null) {
			System.out.println("Event with id " + eventId + " not found");
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		System.out.println(currentEvent.getType().toString());
		System.out.println(event.getType().toString());

		currentEvent.setTime(event.getTime());
		currentEvent.setNotes(event.getNotes());
		currentEvent.setType(event.getType());

		eventService.updateEvent(id, currentEvent);
		return new ResponseEntity<Event>(currentEvent, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}/{eventId}")
	public ResponseEntity<Event> deleteUser(@PathVariable("id") long id, @PathVariable("eventId") long eventId) {
		System.out.println("Fetching & Deleting Event with id " + eventId);

		Event currentEvent = eventService.findEventById(id, eventId);

		if (currentEvent == null) {
			System.out.println("Event with id " + eventId + " not found");
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		eventService.deleteEventById(id, eventId);
		return new ResponseEntity<Event>(HttpStatus.OK);
	}
}
