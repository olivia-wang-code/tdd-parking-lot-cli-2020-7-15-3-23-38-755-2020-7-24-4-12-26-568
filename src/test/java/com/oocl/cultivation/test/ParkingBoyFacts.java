package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_park_given_car() {
        Car car = new Car(1);
        ParkingBoy parkingBoy=new ParkingBoy();

        assertEquals(new Ticket(1).getId(), parkingBoy.parkCar(car).getId());
    }
    @Test
    void should_return_car_when_get_car_given_ticket() {
        Car car = new Car(1);
        ParkingBoy parkingBoy=new ParkingBoy();

        assertEquals(car.getId(), parkingBoy.getCarByTicket(new Ticket(car)).getId());
    }

}
