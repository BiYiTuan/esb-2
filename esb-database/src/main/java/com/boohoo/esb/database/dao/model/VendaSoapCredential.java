package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VendaSoapCredentials database table.
 * 
 */
@Entity
@Table(name="VendaSoapCredentials")
public class VendaSoapCredential implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String consumerName;
	private String operation;
	private String password;
	private String username;

	public VendaSoapCredential() {
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
	public String getConsumerName() {
		return this.consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}


	@Column(nullable=false, length=50)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}


	@Column(nullable=false, length=50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(nullable=false, length=50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}