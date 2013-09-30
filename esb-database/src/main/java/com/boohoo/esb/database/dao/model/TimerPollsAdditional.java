package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TimerPollsAdditional database table.
 * 
 */
@Entity
@Table(name="TimerPollsAdditional")
public class TimerPollsAdditional implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String additionalValue;
	private String name;
	private int timerPollsId;

	public TimerPollsAdditional() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(nullable=false, length=50)
	public String getAdditionalValue() {
		return this.additionalValue;
	}

	public void setAdditionalValue(String additionalValue) {
		this.additionalValue = additionalValue;
	}


	@Column(nullable=false, length=50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false)
	public int getTimerPollsId() {
		return this.timerPollsId;
	}

	public void setTimerPollsId(int timerPollsId) {
		this.timerPollsId = timerPollsId;
	}

}