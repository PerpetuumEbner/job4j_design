package ru.job4j.lsp.parking;

public class Truck implements Type {
    @Override
    public boolean checkLength(Car car) {
        return car.length > 1;
    }
}