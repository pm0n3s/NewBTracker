//package com.NewBornTracker.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.NewBornTracker.model.Event;
//import com.NewBornTracker.model.User;
//import com.NewBornTracker.model.abstracts.EventType;
//import com.NewBornTracker.service.EventService;
//import com.NewBornTracker.service.UserService;
//
//@RestController
//@RequestMapping("events")
//public class EventController {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private EventService eventService;
//
//	// read user
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//		User u = userService.findById(id);
//		return new ResponseEntity<User>(u, HttpStatus.OK);
//	}
//
//	// create event
//	@PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> createEvent(@PathVariable("id") long id, @RequestBody Event event,
//			UriComponentsBuilder ucBuilder) {
//		if (userService.isUserExist(id)) {
//			EventType et = eventService.saveEventType(event.getType());
//			eventService.saveEvent(id, event, et);
//			return new ResponseEntity<Void>(HttpStatus.CREATED);
//		}
//		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//	}
//
//	// update event
//	@PutMapping(value = "/{id}/{eventId}")
//	public ResponseEntity<Event> updateUser(@PathVariable("id") Long id, @PathVariable("eventId") Long eventId,
//			@RequestBody Event event) {
//		Event ev = eventService.updateEvent(event);
//		return new ResponseEntity<Event>(ev, HttpStatus.OK);
//	}
//
//	//delete event
//	@DeleteMapping(value = "/{id}/{eventId}")
//	public ResponseEntity<Event> deleteUser(@PathVariable("id") long id, @PathVariable("eventId") long eventId) {
//		System.out.println("Fetching & Deleting Event with id " + eventId);
//
//		Event currentEvent = eventService.findEventById(eventId);
//
//		if (currentEvent == null) {
//			System.out.println("Event with id " + eventId + " not found");
//			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
//		}
//
//		eventService.deleteEventById(id, eventId);
//		return new ResponseEntity<Event>(HttpStatus.OK);
//	}
//}
