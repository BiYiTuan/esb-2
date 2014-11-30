package com.esb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A very simple entity class for a flight - every flight has:
 * - a flight number
 * - a departure airport
 * - an arrival airport
 */
@Entity
@Table(name = "flights")
public class Flight {

    private String number;
    private String departure;
    private String arrival;

    @Id
    @Column(length = 12)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(length = 3)
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Column(length = 3)
    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return String.format("[flight %s from %s to %s]", number, departure, arrival);
    }
}