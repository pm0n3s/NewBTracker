package com.NewBornTracker.dao;

import com.NewBornTracker.model.User;

public interface UserDao {

	User findById(Long id);
	
	User save(User user);
	
	void delete(Long id);
	
	User findByUsername(String name);
}
