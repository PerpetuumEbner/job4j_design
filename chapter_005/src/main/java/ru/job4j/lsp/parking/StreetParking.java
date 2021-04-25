package ru.job4j.lsp.parking;

public class StreetParking implements Parking {
    private int[][] carPlace;
    private int[][] truckPlace;
    private int carSize = 1;
    private int placesForTrucks;
    private int placesForCars;

    public StreetParking(int placesForTrucks, int placesForCars) {
        this.placesForTrucks = placesForTrucks;
        this.placesForCars = placesForCars;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean pickUp(Car car) {
        return false;
    }
}