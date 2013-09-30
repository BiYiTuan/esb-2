package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SageMasterStock database table.
 * 
 */
@Entity
@Table(name="SageMasterStock")
public class SageMasterStock implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int quantity;
	private String sku;
	private String updatedDateTime;

	public SageMasterStock() {
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


	@Column(nullable=false, length=50)
	public String getUpdatedDateTime() {
		return this.updatedDateTime;
	}

	public void setUpdatedDateTime(String updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SageMasterStock [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", sku=");
		builder.append(sku);
		builder.append(", updatedDateTime=");
		builder.append(updatedDateTime);
		builder.append("]");
		return builder.toString();
	}
	
	
}