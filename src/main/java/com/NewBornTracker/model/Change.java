package com.NewBornTracker.model;

import com.NewBornTracker.model.abstracts.EventType;
import com.NewBornTracker.model.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("change")
public class Change extends EventType{
	
	private ChangeType changeType;
	
	public Change() {};

	public Change(ChangeType changeType) {
		this.changeType = changeType;
	}

	public ChangeType getChangeType() {
		return changeType;
	}

	public void setChangeType(ChangeType changeType) {
		this.changeType = changeType;
	}

	@Override
	public String toString() {
		return "Change [changeType=" + changeType + "]";
	}

}
