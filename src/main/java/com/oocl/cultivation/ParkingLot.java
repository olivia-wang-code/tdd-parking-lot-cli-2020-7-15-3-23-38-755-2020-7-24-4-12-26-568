package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int count;

    public ParkingLot(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private Map<Ticket, Car> parkingCarMap = new HashMap<>();

    public Map<Ticket, Car> getParkingCarMap() {
        return parkingCarMap;
    }

    public void setParkingCarMap(Map<Ticket, Car> parkingCarMap) {
        this.parkingCarMap = parkingCarMap;
    }
}
