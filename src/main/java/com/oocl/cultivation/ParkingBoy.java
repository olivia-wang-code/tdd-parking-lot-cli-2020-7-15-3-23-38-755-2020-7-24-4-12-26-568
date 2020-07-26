package com.oocl.cultivation;

public class ParkingBoy {
    public Ticket parkCar(Car car){
        return new Ticket(car);
    }
    public Car getCarByTicket(Ticket ticket){
        return new Car(ticket.getId());
    }

}
