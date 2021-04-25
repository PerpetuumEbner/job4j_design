package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreetParkingTest {

    @Ignore
    @Test
    public void whenPickUp() {
        Parking parking = new StreetParking(2, 2);
        Car car = new Car("BMW", 1);
        Assert.assertTrue(parking.park(car));
    }

    @Ignore
    @Test
    public void whenUnsuccessfulPickUp() {
        Parking parking = new StreetParking(2, 2);
        Car car = new Car("BMW", 1);
        assertThat(parking.park(car), is(0));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTheSizeIsWrong() {
        Parking parking = new StreetParking(2, 2);
        Car car = new PassengerCar("VW");
        Assert.assertTrue(parking.park(car));
    }

    @Ignore
    @Test
    public void whenPickUpTruck() {
        Parking parking = new StreetParking(2, 2);
        Car car = new Truck("MAN", 3);
        assertThat(parking.park(car), is(1));
    }

    @Ignore
    @Test
    public void whenUnsuccessfulPickUpTruck() {
        Parking parking = new StreetParking(1, 3);
        parking.park(new Truck("Mercedes", 4));
        Car car = new Truck("Mercedes", 3);
        assertThat(parking.park(car), is(0));
    }

    @Ignore
    @Test
    public void whenTruckParkedSeveralPlacesOfPassengerCars() {
        Parking parking = new StreetParking(1, 4);
        parking.park(new Truck("Volvo", 4));
        Car car = new Truck("Renault", 4);
        assertThat(parking.park(car), is(1));
    }
}