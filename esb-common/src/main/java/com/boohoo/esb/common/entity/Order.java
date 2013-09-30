package com.boohoo.esb.common.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A pojo representing an Order.
 */

@XStreamAlias("order")
public class Order {

    private int id;
    private String item;
    private int amount;
    private String description;
    private boolean processed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", item=");
		builder.append(item);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", description=");
		builder.append(description);
		builder.append(", processed=");
		builder.append(processed);
		builder.append("]");
		return builder.toString();
	}
}