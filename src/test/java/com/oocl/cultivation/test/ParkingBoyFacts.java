package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_park_given_car() {
        Ticket ticket=new Ticket("test");
        ParkingBoy parkingBoy = new ParkingBoy();

        assertEquals(ticket.getId(),parkingBoy.parkCar().getId());
    }
}
