package com.oocl.cultivation;

import com.oocl.cultivation.exception.NotEnoughSeatException;
import com.oocl.cultivation.exception.NullTicketException;
import com.oocl.cultivation.exception.WrongTicketException;

import java.util.List;

public class ParkingBoy {
    public Ticket parkCar(List<ParkingLot> parkingLots, Car car) throws NotEnoughSeatException {
        Ticket ticket = new Ticket(car);
        for(int i = 0;i < parkingLots.size();i++) {
            if(parkingLots.get(i).getParkingCarMap().size()<10){
                parkingLots.get(i).getParkingCarMap().put(ticket, car);
                return ticket;
            }
        }
        throw new NotEnoughSeatException("λ�ò���");
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
