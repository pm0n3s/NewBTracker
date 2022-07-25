package com.NewBornTracker.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NewBornTracker.model.Change;
import com.NewBornTracker.model.Event;
import com.NewBornTracker.model.Feed;
import com.NewBornTracker.model.Sleep;
import com.NewBornTracker.model.User;
import com.NewBornTracker.model.enums.ChangeType;

@Service
@Transactional
public class UserService {

	static {
		userMap = populateMap();
	}

	private static HashMap<Long, User> userMap;

	private static HashMap<Long, User> populateMap() {
		HashMap<Long, User> um = new HashMap<Long, User>();
		um.put(0L, new User(0L, "pat", "pat.bodin@email.com", "555-1234", "pat"));
		um.get(0L).setEvent(new Event(10001L, LocalDateTime.now(), new Change(ChangeType.PEE), "only damp"));
		um.get(0L).setEvent(new Event(10002L, "07-21-2022 11:38", new Feed(new BigDecimal(18.5d)) , "finished it all without problem"));
		um.get(0L).setEvent(new Event(10003L, LocalDateTime.now(), new Sleep(LocalDateTime.now().plusHours(3L)) , "was a bit fussy going down but once asleep was ok"));
		return um;
	}

	private static final AtomicLong counter = new AtomicLong();
	
	public HashMap<Long, User> getUserMap() {
		return userMap;
	}

	public void insertUser(Long id, User user) {
		UserService.userMap.put(id, user);
	}

	public HashMap<Long, User> findAllUsers() {
		return userMap;
	}

	public User findById(long id) {
		if (userMap.containsKey(id)) {
			return userMap.get(id);
		}
		return null;
	}

	public User findByName(String name) {
		for (User user : userMap.values()) {
			if (user.getUserName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		userMap.put(user.getId(), user);
	}

	public void updateUser(User user) {
		userMap.replace(user.getId(), user);
	}

	public void deleteUserById(long id) {

		if (userMap.containsKey(id)) {
			userMap.remove(id);
		}
	}

	public boolean isUserExist(long id) {
		return findById(id) != null;
	}

}
