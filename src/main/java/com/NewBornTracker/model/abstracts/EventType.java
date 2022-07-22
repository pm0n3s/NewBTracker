package com.NewBornTracker.model.abstracts;

import com.NewBornTracker.model.Change;
import com.NewBornTracker.model.Feed;
import com.NewBornTracker.model.Sleep;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Change.class, name = "change"), @Type(value = Sleep.class, name = "sleep"),
		@Type(value = Feed.class, name = "feed") })
public abstract class EventType {

}
