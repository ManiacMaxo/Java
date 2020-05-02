package main;

public abstract class Car {
    Model model;
    int year;
    int price;
    EngineType engineType;
    String registrationNumber;

    public Car(Model model, int year, int price, EngineType engineType, String registrationNumber) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
        this.registrationNumber = registrationNumber;
    }


    /**
     * Returns the model of the car.
     */
    public Model getModel() {
        return this.model;
    }

    /**
     * Returns the year of manufacture of the car.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Returns the price of the car.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Returns the engine type of the car.
     */
    public EngineType getEngineType() {
        return this.engineType;
    }

    /**
     * Returns the unique registration number of the car.
     */
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
}
