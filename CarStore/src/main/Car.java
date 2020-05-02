package main;

public abstract class Car implements Comparable<Car> {
    Model model;
    int year;
    int price;
    EngineType engineType;
    Region region;
    String registrationNumber;

    public Car(Model model, int year, int price, EngineType engineType, Region region) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
        this.region = region;

        this.registrationNumber = Region.getPrefix(this.region) + Region.getNumber() + Region.getChars();
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

    @Override
    public int compareTo(Car otherCar) {
        int val = this.model.compareTo(otherCar.getModel());
        if (val == 0) {
            val = this.year - otherCar.getYear();
        }
        return val;
    }

    public String toString() {
        return String.format("%s %d $%d %s %s", this.model, this.year, this.price, this.engineType, this.registrationNumber);
    }
}
