package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.Arrays;

public class Cars {
    private CarBrandName brandName;
    private final int yearOfIssue;
    private final boolean condition;
    private final String[] completion;

    public CarBrandName getBrandName() {
        return brandName;
    }

    public void setCarBrandName(CarBrandName brandName) {
        this.brandName = brandName;
    }

    public Cars(CarBrandName brandName, int yearOfIssue, boolean condition, String... completion) {
        this.brandName = brandName;
        this.yearOfIssue = yearOfIssue;
        this.condition = condition;
        this.completion = completion;
    }

    @Override
    public String toString() {
        return "Cars{"
                + "brandName=" + brandName
                + ", yearOfIssue=" + yearOfIssue
                + ", condition=" + condition
                + ", completion=" + Arrays.toString(completion)
                + '}';
    }

    public static void main(String[] args) {
        final Cars cars = new Cars(new CarBrandName("ŠKODA"), 2019, true, "Heated steering wheel", "Cruise control", "ABS");
        CarBrandName carBrandName = new CarBrandName("ŠKODA");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(cars));

        final String carsJson = "{\"brandName\":{\"brandName\":\"ŠKODA\"},"
                + "\"yearOfIssue\":2019,"
                + "\"condition\":true,"
                + "\"completion\": [\"Heated steering wheel\", \"Cruise control\", \"ABS\"]}";
        final Cars carsMode = gson.fromJson(carsJson, Cars.class);
        System.out.println(carsMode);

        cars.setCarBrandName(carBrandName);
        carBrandName.setCars(cars);
        System.out.println(new JSONObject(carBrandName));
    }
}