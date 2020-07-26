package com.oocl.cultivation;

import java.util.Random;

public class Ticket {
    private int id;

    public Ticket(int id) {
        this.id = id;
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
