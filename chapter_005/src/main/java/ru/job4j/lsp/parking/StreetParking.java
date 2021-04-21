package ru.job4j.lsp.parking;

public class StreetParking implements Place {
    @Override
    public boolean verification(Parking parking) {
        return false;
    }
}