package ru.job4j.lsp.parking;

import java.util.stream.IntStream;

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
        boolean result = true;
        if (checkSizeMachine(car)) {
            if (placesForCars < carPlaces.length) {
                carPlaces[placesForCars++] = car;
            } else {
                result = false;
            }
        } else {
            if (placesForTrucks < truckPlaces.length) {
                truckPlaces[placesForTrucks++] = car;
            } else if (placesForTrucks > truckPlaces.length || placesForCars >= carPlaces.length) {
                result = false;
            } else {
                IntStream.range(0, car.getSize()).forEachOrdered(index -> carPlaces[placesForCars++] = car);
            }
        }
        return result;
    }

    public boolean checkSizeMachine(Car car) {
        boolean result = false;
        if (car.getSize() == carSize) {
            result = true;
        }
        if (car.getSize() > carSize) {
            result = false;
        }
        if (car.getSize() < carSize) {
            throw new ArrayIndexOutOfBoundsException("Размер машины не может быть меньше единицы.");
        }
        return result;
    }
}