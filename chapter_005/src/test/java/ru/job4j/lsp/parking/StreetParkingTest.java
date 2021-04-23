package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class StreetParkingTest {

    @Ignore
    @Test
    public void whenPickUp() {
        Parking parking = new StreetParking();
        Car car = new Car("BMW", 1);
        Assert.assertTrue(parking.park(car));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTheSizeIsWrong() {
        Parking parking = new StreetParking();
        Car car = new PassengerCar("VW");
        Assert.assertTrue(parking.park(car));
    }
}