package com.oocl.cultivation;

import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkingCarMap;

    public Map<Ticket, Car> getParkingCarMap() {
        return parkingCarMap;
    }

    public void setParkingCarMap(Map<Ticket, Car> parkingCarMap) {
        this.parkingCarMap = parkingCarMap;
    }
}
