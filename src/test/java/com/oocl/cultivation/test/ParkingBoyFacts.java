package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_park_given_car() {
        ParkingBoy parkingBoy=mock(ParkingBoy.class);
        when(parkingBoy.parkCar()).thenReturn(new Ticket(1));
        Ticket ticket = new Ticket(1);

        assertEquals(ticket.getId(), parkingBoy.parkCar().getId());
    }

}
