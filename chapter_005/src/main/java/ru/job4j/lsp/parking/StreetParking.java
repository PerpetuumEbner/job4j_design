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
        boolean result = true;
        if (car.getSize() < carSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (placesForCars < carPlaces.length && car.getSize() == carSize) {
            carPlaces[placesForCars++] = car;
        }
        if (placesForTrucks < truckPlaces.length) {
            truckPlaces[placesForTrucks++] = car;
        } else if (placesForCars < carPlaces.length && car.getSize() > carSize) {
            int size = car.getSize();
            for (int index = 1; index < size; index++) {
                carPlaces[placesForCars++] = car;
            }
        } else {
            result = false;
        }
        return result;
    }
}