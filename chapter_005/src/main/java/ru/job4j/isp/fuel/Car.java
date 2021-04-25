package ru.job4j.isp.fuel;

public class Car implements Refueling {
    String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Car car = new Car("Mitsubishi Pajero Sport");

    @Override
    public void refuelGasoline() {
        System.out.println(car.getName() + " refueling");
    }

    @Override
    public void refuelGas() {
        throw new UnsupportedOperationException(car.getName() + " can't refuel.");
    }

    @Override
    public void refuelDieselGasoline() {
        throw new UnsupportedOperationException(car.getName() + " can't refuel.");
    }
}