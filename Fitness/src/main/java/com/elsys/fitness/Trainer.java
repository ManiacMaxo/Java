package com.elsys.fitness;

public abstract class Trainer {
    String name;
    String surname;
    int wage;
    int type;
    Fitness fitness;

    public Trainer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.wage = 500;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getWage() {
        return wage;
    }

    public int getType() {
        return type;
    }
}
