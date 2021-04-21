package ru.job4j.lsp.parking;

public class PassengerCar implements Type {
    @Override
    public boolean checkLength(Car car) {
        return car.length == 1;
    }
}