package com.boohoo.esb.database.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FrontendConnections database table.
 * 
 */
@Entity
@Table(name="FrontendConnections")
public class FrontendConnection implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String docLitUrl;
	private byte isCategoryUpdates;
	private byte isOrderRetrieval;
	private byte isPriceUpdates;
	private byte isProductUpdates;
	private byte isStockUpdates;
	private String name;
	private String password;
	private String rpcUrl;
	private String type;
	private String username;

	public FrontendConnection() {
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


	@Column(nullable=false, length=255)
	public String getDocLitUrl() {
		return this.docLitUrl;
	}

	public void setDocLitUrl(String docLitUrl) {
		this.docLitUrl = docLitUrl;
	}


	@Column(nullable=false)
	public byte getIsCategoryUpdates() {
		return this.isCategoryUpdates;
	}

	public void setIsCategoryUpdates(byte isCategoryUpdates) {
		this.isCategoryUpdates = isCategoryUpdates;
	}


	@Column(nullable=false)
	public byte getIsOrderRetrieval() {
		return this.isOrderRetrieval;
	}

	public void setIsOrderRetrieval(byte isOrderRetrieval) {
		this.isOrderRetrieval = isOrderRetrieval;
	}


	@Column(nullable=false)
	public byte getIsPriceUpdates() {
		return this.isPriceUpdates;
	}

	public void setIsPriceUpdates(byte isPriceUpdates) {
		this.isPriceUpdates = isPriceUpdates;
	}


	@Column(nullable=false)
	public byte getIsProductUpdates() {
		return this.isProductUpdates;
	}

	public void setIsProductUpdates(byte isProductUpdates) {
		this.isProductUpdates = isProductUpdates;
	}


	@Column(nullable=false)
	public byte getIsStockUpdates() {
		return this.isStockUpdates;
	}

	public void setIsStockUpdates(byte isStockUpdates) {
		this.isStockUpdates = isStockUpdates;
	}


	@Column(nullable=false, length=50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=255)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(nullable=false, length=255)
	public String getRpcUrl() {
		return this.rpcUrl;
	}

	public void setRpcUrl(String rpcUrl) {
		this.rpcUrl = rpcUrl;
	}


	@Column(nullable=false, length=20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Column(nullable=false, length=255)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}