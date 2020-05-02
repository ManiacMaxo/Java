package main;

public class EngineType {
    String name;
    int horsepower;
    int torque;
    double weight;
    boolean isElectric;

    public EngineType(String name, int horsepower, int torque, double weight, boolean isElectric) {
        this.name = name;
        this.horsepower = horsepower;
        this.torque = torque;
        this.weight = weight;
        this.isElectric = isElectric;
    }
}
