package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AllocatedOrderLines database table.
 * 
 */
@Entity
@Table(name="AllocatedOrderLines")
public class AllocatedOrderLine implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int allocatedOrderId;
	private int quantity;
	private String sku;
	private int status;

	public AllocatedOrderLine() {
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


	@Column(nullable=false)
	public int getAllocatedOrderId() {
		return this.allocatedOrderId;
	}

	public void setAllocatedOrderId(int allocatedOrderId) {
		this.allocatedOrderId = allocatedOrderId;
	}


	@Column(nullable=false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Column(nullable=false, length=50)
	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}


	@Column(nullable=false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}