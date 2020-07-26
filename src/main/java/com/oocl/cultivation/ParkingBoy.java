package com.oocl.cultivation;

import com.oocl.cultivation.exception.NullTicketException;
import com.oocl.cultivation.exception.WrongTicketException;

public class ParkingBoy {
    public Ticket parkCar(ParkingLot parkingLot, Car car){
        Ticket ticket = new Ticket(car);
        if(parkingLot.getParkingCarMap().size()<10){
            parkingLot.getParkingCarMap().put(ticket, car);
        }else{
            return null;
        }
        return ticket;
    }
    public Car getCarByTicket(ParkingLot parkingLot, Ticket ticket) throws Exception {
        if(ticket.getId() == 0){
            throw new NullTicketException("请提供停车票");
        }
        //暂时存car,remove删除map里的ticket：car
        Car car = parkingLot.getParkingCarMap().get(ticket);
        if(car==null){
            throw new WrongTicketException("无法识别的停车罚单");
        }
        parkingLot.getParkingCarMap().remove(ticket);
        return car;
    }

}
