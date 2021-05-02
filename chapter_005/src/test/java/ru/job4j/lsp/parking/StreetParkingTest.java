package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreetParkingTest {

    @Test
    public void whenPark() {
        Parking parking = new StreetParking(2, 2);
        Car car = new Car("BMW", 1);
        Assert.assertTrue(parking.park(car));
    }

    @Test
    public void whenUnsuccessfulPark() {
        Parking parking = new StreetParking(1, 2);
        Car car = new Car("BMW", 4);
        Assert.assertFalse(parking.park(car));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTheSizeIsWrong() {
        Parking parking = new StreetParking(2, 2);
        Car car = new Car("VW", 0);
        Assert.assertTrue(parking.park(car));
    }

    @Test
    public void whenParkTruck() {
        Parking parking = new StreetParking(2, 2);
        Car car = new Truck("MAN", 3);
        Assert.assertTrue(parking.park(car));
    }

    @Test
    public void whenUnsuccessfulParkTruck() {
        Parking parking = new StreetParking(1, 3);
        parking.park(new Truck("Mercedes", 4));
        Car car = new Truck("Mercedes", 3);
        Assert.assertTrue(parking.park(car));
        assertThat(parking.park(car), is(0));
    }

    @Test
    public void whenTruckParkedSeveralPlacesOfPassengerCars() {
        Parking parking = new StreetParking(1, 4);
        parking.park(new Truck("Volvo", 4));
        Car car = new Truck("Renault", 4);
        assertThat(parking.park(car), is(1));
    }
}