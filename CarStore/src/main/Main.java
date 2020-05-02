package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        CarStore store = new CarStore();
        store.add(new SportsCar(Model.MERCEDES, 2019, 120000, EngineType.ELECTRIC, Region.SOFIA));
        store.add(new SportsCar(Model.BMW, 2016, 60000, EngineType.DIESEL, Region.SOFIA));
        for (Car car : store.getCars()) {
            System.out.println(car.toString());
        }
    }
}
