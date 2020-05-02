package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CarStore {
    protected ArrayList<Car> cars;

    public CarStore() {
        this.cars = new ArrayList<Car>();
    }

    /**
     * Adds the specified car in the store.
     *
     * @return true if the car was added successfully to the store
     */
    public boolean add(Car car) {
        return this.cars.add(car);
    }

    /**
     * Adds all of the elements of the specified collection in the store.
     *
     * @return true if the store cars are changed after the execution
     * (i.e. at least one new car is added to the store)
     */
    public boolean addAll(Collection<Car> cars) {
        int count = 0;
        for (Car car : cars) {
            if (this.cars.add(car)) {
                count += 1;
            }
        }
        return count > 0;
    }

    /**
     * Removes the specified car from the store.
     *
     * @return true if the car is successfully removed from the store
     */
    public boolean remove(Car car) {
        for (Car obj : this.cars) {
            if (obj == car) {
                this.cars.remove(obj);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a car from the store by its registration number.
     *
     * @throws CarNotFoundException if a car with this registration number is not found in the store
     **/
    public Car getCarByRegistrationNumber(String registrationNumber) throws CarNotFoundException {
        for (Car car : this.cars) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                return car;
            }
        }
        throw new CarNotFoundException();
    }

    /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
    public Collection<Car> getCarsByModel(Model model) {
        ArrayList<Car> output = new ArrayList<Car>();
        for (Car car : this.cars) {
            if (car.getModel() == model) {
                output.add(car);
            }
        }
        return output;
    }

    /**
     * Returns all cars sorted by their natural ordering
     * (according to the implementation of the Comparable<Car> interface).
     **/
    public Collection<Car> getCars() {
        Collections.sort(this.cars);
        return this.cars;
    }

    /**
     * Returns all cars sorted according to the
     * order induced by the specified comparator.
     */
    public Collection<Car> getCars(Comparator<Car> comparator) {
        Collections.sort(this.cars, comparator);
        return this.cars;
    }

    /**
     * Returns all cars sorted according to the
     * given comparator and boolean flag for order.
     *
     * @param isReversed if true, the cars should be returned in reverse order
     */
    public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed) {
        Collections.sort(this.cars, comparator);
        if (isReversed) {
            Collections.reverse(this.cars);
        }
        return this.cars;
    }

    /**
     * Returns the total number of cars in the store.
     */
    public int getNumberOfCars() {
        return this.cars.size();
    }

    /**
     * Returns the total price of all cars in the store.
     */
    public int getTotalPriceOfCars() {
        int price = 0;
        for (Car car : this.cars) {
            price += car.getPrice();
        }
        return price;
    }
}
