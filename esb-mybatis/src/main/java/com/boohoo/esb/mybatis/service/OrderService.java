package com.boohoo.esb.mybatis.service;
import java.util.Random;

import com.boohoo.esb.common.entity.Order;

/**
 * Bean that generates and process orders.
 */
public class OrderService {

    private int counter;
    private Random ran = new Random();

    /**
     * Generates a new order
     */
    public Order generateOrder() {
        Order order = new Order();
        order.setId(counter++);
        order.setItem(counter % 2 == 0 ? "111" : "222");
        order.setAmount(ran.nextInt(10) + 1);
        order.setDescription(counter % 2 == 0 ? "Camel in Action" : "ActiveMQ in Action");
        return order;
    }

    /**
     * Processes the order
     *
     * @param order  the order
     * @return the transformed order
     */
    public String processOrder(Order order) {
        return "Processed order id " + order.getId() + " item " + order.getItem() + " of " + order.getAmount() + " copies of " + order.getDescription();
    }
}