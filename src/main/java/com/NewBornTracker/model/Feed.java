package com.NewBornTracker.model;

import java.math.BigDecimal;

import com.NewBornTracker.model.abstracts.EventType;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("feed")
public class Feed extends EventType{

	private BigDecimal amount;
	
	public Feed() {};

	public Feed(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
