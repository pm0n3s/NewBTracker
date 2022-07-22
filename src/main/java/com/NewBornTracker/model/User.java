package com.NewBornTracker.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2878028119510431602L;

	public User() {};

	private Long Id;
	private String userName;
	private String email;
	private String phone;
	private String password;
	private ArrayList<Event> eventList;

	public User(Long id, String userName, String email, String phone, String password) {
		super();
		this.Id = id;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.eventList = new ArrayList<Event>();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Event> getEventList(){
		return eventList;
	}
	
	public void setEvent(Event event) {
		this.eventList.add(event);
	}

	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", userName=" + userName + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", eventList=" + eventList + "]";
	}
	
}
