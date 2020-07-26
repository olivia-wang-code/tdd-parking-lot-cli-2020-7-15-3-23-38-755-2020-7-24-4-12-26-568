package com.oocl.cultivation;

import com.oocl.cultivation.exception.NotEnoughSeatException;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parkCar(List<ParkingLot> parkingLots, Car car) throws NotEnoughSeatException {
        Ticket ticket = new Ticket(car);
        getMoreEmptySeatsParkingLot(parkingLots).getParkingCarMap().put(new Ticket(car), car);
        return ticket;
    }

    private ParkingLot getMoreEmptySeatsParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot moreEmptySeatsParkingLot=parkingLots.get(0);
        for(int i =1 ;i<parkingLots.size(); i++) {
            double i1 = (double) (moreEmptySeatsParkingLot.getCount() - moreEmptySeatsParkingLot.getParkingCarMap().size())
                    / (double)moreEmptySeatsParkingLot.getCount();
            double i2 = (double)((parkingLots.get(i).getCount() - parkingLots.get(i).getParkingCarMap().size())
                    /(double)(parkingLots.get(i).getCount()));
            if(i1 < i2){
                moreEmptySeatsParkingLot=parkingLots.get(i);
            }
        }
        return moreEmptySeatsParkingLot;
    }
}
