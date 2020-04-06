package com.elsys.fitness;

public class RegisterEmployee extends Trainer {

    public RegisterEmployee(String name, String surname) {
        super(name, surname);
        this.type = 2;
    }

    void newCustomer(Customer customer) {
        customer.card = fitness.availableCards.remove(0);
    }
}
