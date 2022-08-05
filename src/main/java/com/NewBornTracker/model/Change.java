package com.NewBornTracker.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.NewBornTracker.model.abstracts.EventType;
import com.NewBornTracker.model.enums.ChangeType;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("change")
@Entity
@DiscriminatorValue("change")
public class Change extends EventType{
	
	@Column(name="change_type")
	private ChangeType changeType;
	
	public Change() {};

	public Change(ChangeType changeType) {
		super();
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
