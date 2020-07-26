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
            throw new NullTicketException("���ṩͣ��Ʊ");
        }
        //��ʱ��car,removeɾ��map���ticket��car
        Car car = parkingLot.getParkingCarMap().get(ticket);
        if(car==null){
            throw new WrongTicketException("�޷�ʶ���ͣ������");
        }
        parkingLot.getParkingCarMap().remove(ticket);
        return car;
    }

}
