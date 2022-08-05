package com.NewBornTracker.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NewBornTracker.dao.UserDao;
import com.NewBornTracker.model.User;

@Service
@Transactional
public class UserService {


	@Autowired
	private UserDao userDao;

	public User findById(Long id) {
		return userDao.findById(id);
	}

	public User findByName(String name) {
		
		User u = userDao.findByUsername(name);
		if(u != null) {
			if (u.getUserName().equalsIgnoreCase(name)) {
				return u;
			}
		}
		return null;
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}

	public void updateUser(User user) {
		//TODO 
	}

	public void deleteUserById(long id) {
		//TODO
	}

	public boolean isUserExist(long id) {
		return findById(id) != null;
	}

	public User mapUser(Map<String, String> userMap) {
		User u = new User();
		u.setUserName(userMap.get("suname"));
		u.setPassword(userMap.get("spword"));
		u.setEmail(userMap.get("semail"));
		u.setPhone(userMap.get("sphone"));
		return u;
	}

}
