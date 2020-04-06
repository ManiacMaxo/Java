package com.elsys.fitness;

public class Customer {
    String name;
    String surname;
    Card card;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Card getCard() {
        return card;
    }

    void train() throws Exception {
        this.card.train();
    }

}
