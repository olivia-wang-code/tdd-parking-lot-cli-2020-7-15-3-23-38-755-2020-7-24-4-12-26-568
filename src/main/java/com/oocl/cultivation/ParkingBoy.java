package com.oocl.cultivation;

public class ParkingBoy {
    public Ticket parkCar(ParkingLot parkingLot, Car car){
        Ticket ticket = new Ticket(car);
        parkingLot.getParkingCarMap().put(ticket, car);
        return ticket;
    }
    public Car getCarByTicket(Ticket ticket){
        return new Car(ticket.getId());
    }

}
