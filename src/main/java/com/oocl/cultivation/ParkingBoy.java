package com.oocl.cultivation;

public class ParkingBoy {
    public Ticket parkCar(){
        return new Ticket().generateTicket();
    }
    public Car getCarByTicket(Ticket ticket){
        return new Car(2);
    }

}
