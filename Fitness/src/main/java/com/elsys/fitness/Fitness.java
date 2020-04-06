package com.elsys.fitness;

import java.util.ArrayList;

public class Fitness {
    public ArrayList<Card> availableCards;
    public ArrayList<Trainer> fitnessTrainers;
    public ArrayList<Trainer> groupTrainers;
    public ArrayList<Trainer> registerEmployees;
    public ArrayList<Customer> customers;


    public void hireEmployee(String name, String surname, int type) {
        switch (type) {
            case 0:
                fitnessTrainers.add(new FitnessTrainer(name, surname));
                break;
            case 1:
                groupTrainers.add(new GroupTrainer(name, surname));
                break;
            case 2:
                registerEmployees.add(new RegisterEmployee(name, surname));
                break;
        }
    }

    public void registerCustomer(String name, String surname) {
        Customer temp = new Customer(name, surname);

        this.customers.add(temp);
    }

    public void performTraining(String name, boolean group, ArrayList<Customer> customers) throws Exception {
        if (group) {
            new Session(name, true, customers, groupTrainers.get((int)Math.random() * groupTrainers.size()));
        } else {
            new Session(name, false, customers, fitnessTrainers.get((int)Math.random() * fitnessTrainers.size()));
        }
    }

}
