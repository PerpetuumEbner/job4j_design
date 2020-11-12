package ru.job4j.serialization;

public class CarBrandName {
    private final String brandName;
    private Cars cars;

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public CarBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "CarBrandName{"
                + "brandName='" + brandName + '\''
                + '}';
    }
}