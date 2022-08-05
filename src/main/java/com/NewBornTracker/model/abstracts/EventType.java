package com.NewBornTracker.model.abstracts;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.DiscriminatorType;

import com.NewBornTracker.model.Change;
import com.NewBornTracker.model.Event;
import com.NewBornTracker.model.Feed;
import com.NewBornTracker.model.Sleep;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "selectType")
@JsonSubTypes({ @Type(value = Change.class, name = "change"), @Type(value = Sleep.class, name = "sleep"),
		@Type(value = Feed.class, name = "feed") })
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="selectType", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("abs")
@Table(name="event_type")
public class EventType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy="selectType")
	private Event event;

	public EventType() {}
	
	public EventType(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	};
	
	
}
