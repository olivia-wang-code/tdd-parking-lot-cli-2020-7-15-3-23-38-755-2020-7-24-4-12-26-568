package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import com.oocl.cultivation.exception.NotEnoughSeatException;
import com.oocl.cultivation.exception.NullTicketException;
import com.oocl.cultivation.exception.WrongTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_park_given_car() throws NotEnoughSeatException {
        //given
        Car car = new Car(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(parkingLots, car);

        //then
        assertEquals(new Ticket(1).getId(), ticket.getId());
    }

    @Test
    void should_return_car_when_get_car_given_ticket() throws Exception {
        //given
        Car car = new Car(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(parkingLots, car);

        //then
        assertEquals(car.getId(), parkingBoy.getCarByTicket(parkingLot, ticket).getId());
    }

    @Test
    void should_return_ticket_when_parking_given_more_cars() throws NotEnoughSeatException {
        //given
        Car theFirstCar = new Car(1);
        Car theSecondCar = new Car(2);

        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);

        //when
        parkingBoy.parkCar(parkingLots, theFirstCar);
        parkingBoy.parkCar(parkingLots, theSecondCar);

        //then
        assertEquals(2, parkingLot.getParkingCarMap().size());
    }

    @Test
    void should_return_car_when_get_cars_given_tickets() throws NotEnoughSeatException {
        //given
        Car theFirstCar = new Car(1);
        Car theSecondCar = new Car(2);

        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);

        //when
        Ticket theFirstCarTicket = parkingBoy.parkCar(parkingLots, theFirstCar);
        Ticket theSecondCarTicket = parkingBoy.parkCar(parkingLots, theSecondCar);

        //then
        assertEquals(theFirstCar.getId(), parkingLot.getParkingCarMap().get(theFirstCarTicket).getId());
        assertEquals(theSecondCar.getId(), parkingLot.getParkingCarMap().get(theSecondCarTicket).getId());
    }

    @Test
    void should_return_none_car_when_get_car_given_false_ticket() throws NotEnoughSeatException {
        //given
        Car theFirstCar = new Car(1);
        Car theSecondCar = new Car(2);

        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);

        //when
        Ticket theSecondCarTicket = parkingBoy.parkCar(parkingLots, theSecondCar);

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
    void should_return_none_car_when_get_car_given_used_ticket() throws Exception {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        Ticket ticket = parkingBoy.parkCar(parkingLots, new Car(1));
        parkingBoy.getCarByTicket(parkingLot,ticket);

        //then
        assertThrows(WrongTicketException.class, () -> parkingBoy.getCarByTicket(parkingLot,ticket));
    }

    @Test
    void should_return_false_when_park_car_given_parkingcar_more_than_10() throws NotEnoughSeatException {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        for(int i=1;i<11;i++) {
            Car car=new Car(i);
            parkingBoy.parkCar(parkingLots,car);
        }

        //when
        Car car=new Car(11);

        //then
        assertThrows(NotEnoughSeatException.class,()-> parkingBoy.parkCar(parkingLots,car));
    }
    @Test
    void should_throw_wrong_ticket_exception_when_get_car_given_false_ticket() throws NotEnoughSeatException {
        //given
        Car car = new Car(1);

        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);

        //when
        parkingBoy.parkCar(parkingLots, car);
        Ticket errorTicket = new Ticket(new Car(2));

        //then
        assertThrows(WrongTicketException.class, () -> parkingBoy.getCarByTicket(parkingLot, errorTicket));
    }
    @Test
    void should_throw_null_ticket_exception_when_get_car_given_null_ticket() throws WrongTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy();

        //then
        assertThrows(NullTicketException.class,()-> parkingBoy.getCarByTicket(parkingLot, new Ticket()));
    }
    @Test
    void should_throw_not_enough_seat_exception_when_park_car_given_parkingcar_more_than_10() throws NotEnoughSeatException {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        for(int i=1;i<11;i++) {
            Car car=new Car(i);
            parkingBoy.parkCar(parkingLots,car);
        }

        //when
        Car car=new Car(11);

        //then
        assertThrows(NotEnoughSeatException.class, ()->parkingBoy.parkCar(parkingLots,car));
    }
    @Test
    void should_return_the_11th_car_in_parking_lot_2_when_parking_car_given_parkingcar_more_than_10() throws NotEnoughSeatException {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingLot firstParkingLot=new ParkingLot();
        ParkingLot secondParkingLot=new ParkingLot();
        List<ParkingLot> parkingLots=new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        for(int i=1;i<11;i++) {
            Car car=new Car(i);
            parkingBoy.parkCar(parkingLots,car);
        }

        //when
        Car car=new Car(11);
        Ticket ticket = parkingBoy.parkCar(parkingLots, car);

        //then
        assertEquals(car.getId(), secondParkingLot.getParkingCarMap().get(ticket).getId());
    }
    @Test
    void should_return_second_parking_lot_when_parking_4th_car_given_there_is_2_cars_in_first_parking_lot_and_1_car_in_second_parking_lot()
            throws NotEnoughSeatException {
        //given
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        ParkingLot firstParkingLot=new ParkingLot();
        ParkingLot secondParkingLot=new ParkingLot();
        firstParkingLot.getParkingCarMap().put(new Ticket(1),new Car(1));
        firstParkingLot.getParkingCarMap().put(new Ticket(2),new Car(2));
        secondParkingLot.getParkingCarMap().put(new Ticket(3),new Car(3));
        List<ParkingLot> parkinglots=new ArrayList<>();
        parkinglots.add(firstParkingLot);
        parkinglots.add(secondParkingLot);

        //when
        Car car=new Car(4);
        smartParkingBoy.parkCar(parkinglots,car);
        //then
        assertEquals(2, parkinglots.get(1).getParkingCarMap().size());
    }
    @Test
    void should_return_second_parking_lot_when_parking_one_car_given_second_has_more_available_seats_than_first() throws NotEnoughSeatException {
        //given
        ParkingLot firstParkingLot=new ParkingLot();
        ParkingLot secondParkingLot=new ParkingLot();
        List<ParkingLot> parkinglots=new ArrayList<>();
        ParkingBoy parkingBoy=new ParkingBoy();
        parkinglots.add(firstParkingLot);
        parkinglots.add(secondParkingLot);
        for (int i = 0; i < 5; i++) {
            firstParkingLot.getParkingCarMap().put(new Ticket(),new Car(i));
        }
        secondParkingLot.getParkingCarMap().put(new Ticket(),new Car(6));


        //when

        parkingBoy.parkCar(parkinglots,new Car(7));

        //then
        assertEquals(2,secondParkingLot.getParkingCarMap().size());
    }
}
