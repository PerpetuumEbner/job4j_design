package ru.job4j.serialization;

public class CarBrandName {
    private final String brandName;

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