package com.oocl.cultivation;

import com.oocl.cultivation.exception.NotEnoughSeatException;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parkCar(List<ParkingLot> parkingLots, Car car) throws NotEnoughSeatException {
        Ticket ticket = new Ticket(car);
        getMostEmptySeatsParkingLot(parkingLots).getParkingCarMap().put(new Ticket(car), car);
        return ticket;
    }

    private ParkingLot getMostEmptySeatsParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot mostEmptySeatsParkingLot=parkingLots.get(0);
        for(int i =1 ;i<parkingLots.size(); i++) {
            if(mostEmptySeatsParkingLot.getParkingCarMap().size()>parkingLots.get(i).getParkingCarMap().size()){
                mostEmptySeatsParkingLot=parkingLots.get(i);
            }
        }
        return mostEmptySeatsParkingLot;
    }
}
