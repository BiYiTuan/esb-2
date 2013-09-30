package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TimerPolls database table.
 * 
 */
@Entity
@Table(name="TimerPolls")
public class TimerPoll implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String lastDateTime;
	private String name;
	private String type;

	public TimerPoll() {
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
	public String getLastDateTime() {
		return this.lastDateTime;
	}

	public void setLastDateTime(String lastDateTime) {
		this.lastDateTime = lastDateTime;
	}


	@Column(nullable=false, length=50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}