package com.oocl.cultivation;

public class ParkingBoy {
    public Ticket parkCar(ParkingLot parkingLot, Car car){
        Ticket ticket = new Ticket(car);
        parkingLot.getParkingCarMap().put(ticket, car);
        return ticket;
    }
    public Car getCarByTicket(ParkingLot parkingLot, Ticket ticket){
        //ÔÝÊ±´æcar,removeÉ¾³ýmapÀïµÄticket£ºcar
        Car car = parkingLot.getParkingCarMap().get(ticket);
        parkingLot.getParkingCarMap().remove(ticket);
        return car;
    }

}
