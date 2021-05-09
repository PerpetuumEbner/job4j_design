package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Test;

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
        parking.park(new Car("BMW", 1));
        Car car = new PassengerCar("VW", 1);
        Assert.assertFalse(parking.park(car));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTheSizeIsWrong() {
        Parking parking = new StreetParking(2, 2);
        Car car = new PassengerCar("VW", 0);
        Assert.assertTrue(parking.park(car));
    }

    @Test
    public void whenParkTruck() {
        Parking parking = new StreetParking(2, 2);
        parking.park(new Truck("MAN", 3));
        Car car = new Truck("Volvo", 3);
        Assert.assertTrue(parking.park(car));
    }

    @Test
    public void whenUnsuccessfulParkTruck() {
        Parking parking = new StreetParking(4, 1);
        parking.park(new Truck("Mercedes", 4));
        parking.park(new Truck("Renault", 4));
        Car car = new Truck("MAN", 3);
        Assert.assertFalse(parking.park(car));
    }

    @Test
    public void whenTruckParkedSeveralPlacesOfPassengerCars() {
        Parking parking = new StreetParking(3, 1);
        parking.park(new Truck("Volvo", 2));
        Car car = new Truck("Renault", 2);
        Assert.assertTrue(parking.park(car));
    }
}