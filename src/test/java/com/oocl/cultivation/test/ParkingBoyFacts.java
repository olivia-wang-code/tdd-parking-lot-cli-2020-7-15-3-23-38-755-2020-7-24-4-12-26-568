package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        Car car = new Car(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket ticket = parkingBoy.parkCar(parkingLot, car);

        //then
        assertEquals(new Ticket(1).getId(), ticket.getId());
    }

    @Test
    void should_return_car_when_get_car_given_ticket() {
        //given
        Car car = new Car(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket ticket = parkingBoy.parkCar(parkingLot, car);

        //then
        assertEquals(car.getId(), parkingBoy.getCarByTicket(parkingLot, ticket).getId());
    }

    @Test
    void should_return_ticket_when_parking_given_more_cars() {
        //given
        Car theFirstCar = new Car(1);
        Car theSecondCar = new Car(2);

        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();

        //when
        parkingBoy.parkCar(parkingLot, theFirstCar);
        parkingBoy.parkCar(parkingLot, theSecondCar);

        //then
        assertEquals(2, parkingLot.getParkingCarMap().size());
    }

    @Test
    void should_return_car_when_get_cars_given_tickets() {
        //given
        Car theFirstCar = new Car(1);
        Car theSecondCar = new Car(2);

        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket theFirstCarTicket = parkingBoy.parkCar(parkingLot, theFirstCar);
        Ticket theSecondCarTicket = parkingBoy.parkCar(parkingLot, theSecondCar);

        //then
        assertEquals(theFirstCar.getId(), parkingLot.getParkingCarMap().get(theFirstCarTicket).getId());
        assertEquals(theSecondCar.getId(), parkingLot.getParkingCarMap().get(theSecondCarTicket).getId());
    }

    @Test
    void should_return_none_car_when_get_car_given_false_ticket() {
        //given
        Car theFirstCar = new Car(1);
        Car theSecondCar = new Car(2);

        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket theSecondCarTicket = parkingBoy.parkCar(parkingLot, theSecondCar);

        //then
        assertNotEquals(theFirstCar.getId(), parkingLot.getParkingCarMap().get(theSecondCarTicket).getId());
    }

    @Test
    void should_return_none_car_when_get_car_given_null_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car car = parkingLot.getParkingCarMap().get(new Ticket());

        //then
        assertEquals(null, car);
    }

    @Test
    void should_return_none_car_when_get_car_given_used_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingBoy.parkCar(parkingLot, new Car(1));
        parkingBoy.getCarByTicket(parkingLot,ticket);

        //when
        Car car = parkingBoy.getCarByTicket(parkingLot,ticket);

        //then
        assertEquals(null, car);
    }

}
