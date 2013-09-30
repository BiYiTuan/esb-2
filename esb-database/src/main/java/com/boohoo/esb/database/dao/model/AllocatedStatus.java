package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AllocatedStatus database table.
 * 
 */
@Entity
@Table(name="AllocatedStatus")
public class AllocatedStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public AllocatedStatus() {
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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}