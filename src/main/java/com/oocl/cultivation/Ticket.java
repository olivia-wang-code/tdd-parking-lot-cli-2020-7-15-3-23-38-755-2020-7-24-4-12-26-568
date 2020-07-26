package com.oocl.cultivation;

import java.util.Random;

public class Ticket {
    private int id;
    private Car car;
    public Ticket(int id) {
        this.id = id;
    }

    public Ticket(Car car){
        this.id=car.getId();
    }

    public Ticket() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Ticket generateTicket(){
        return new Ticket(new Random().nextInt(100));
    }
}
