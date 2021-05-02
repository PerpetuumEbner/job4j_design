package ru.job4j.lsp.parking;

public class StreetParking implements Parking {
    private final Car[] carPlaces;
    private final Car[] truckPlaces;
    private final int carSize = 1;
    private int placesForCars;
    private int placesForTrucks;


    public StreetParking(int carPlaces, int truckPlaces) {
        this.carPlaces = new Car[carPlaces];
        this.truckPlaces = new Car[truckPlaces];
    }

    @Override
    public boolean park(Car car) {
        if (car.getLength() < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (car.getLength() == carSize) {
            carPlaces[placesForCars++] = car;
        } else {
            if (car.getLength() < placesForTrucks) {
                truckPlaces[placesForTrucks++] = car;
            } else {
                int size = car.getLength();
                for (int index = 1; index < size; index++) {
                    carPlaces[placesForCars++] = car;
                }
            }
        }
        return true;
    }
}