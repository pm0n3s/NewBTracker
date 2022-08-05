package com.NewBornTracker.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.NewBornTracker.model.abstracts.EventType;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("feed")
@Entity
@DiscriminatorValue("feed")
public class Feed extends EventType{

	@Column(name="amount")
	private BigDecimal amount;
	
	public Feed() {};

	public Feed(BigDecimal amount) {
		super();
		this.amount = amount;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
