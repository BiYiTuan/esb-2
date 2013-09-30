package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ConsumerCount database table.
 * 
 */
@Entity
@Table(name="ConsumerCount")
public class ConsumerCount implements Serializable {
	private static final long serialVersionUID = 1L;
	private int consumerId;
	private int numberOfConsumers;
	private String route;

	public ConsumerCount() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getConsumerId() {
		return this.consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}


	@Column(nullable=false)
	public int getNumberOfConsumers() {
		return this.numberOfConsumers;
	}

	public void setNumberOfConsumers(int numberOfConsumers) {
		this.numberOfConsumers = numberOfConsumers;
	}


	@Column(nullable=false, length=50)
	public String getRoute() {
		return this.route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

}