package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AllocatedOrders database table.
 * @author ramesh
 */
@Entity
@Table(name="AllocatedOrders")
@NamedNativeQueries(@NamedNativeQuery(name="allocatedOrder.CreateAllocatedOrder",query="call CreateAllocatedOrder(?1,?2,?3)"))
public class AllocatedOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String orderNumber;
	private int status;

	public AllocatedOrder() {
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
	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	@Column(nullable=false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}