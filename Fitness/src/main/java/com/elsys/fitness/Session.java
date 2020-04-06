package com.elsys.fitness;

import java.util.ArrayList;

public class Session {
    String name;
    boolean group;
    ArrayList<Customer> trainees;
    Trainer trainer;

    public Session(String name, boolean group, ArrayList<Customer> trainees, Trainer trainer) throws Exception {
        this.name = name;
        this.group = group;
        this.trainer = trainer;

        if (this.trainer.getType() == 0 && this.group) {
            throw new Exception("Can't assign a fitness trainer to a group!");
        } else if (this.trainer.getType() == 1 && !this.group) {
            throw new Exception("Can't assign a group trainer to a single trainee!");
        } else if (trainees.size() < 3 && this.group) {
            throw new Exception("Can't have a group session with less than 3 trainees!");
        } else if (trainees.size() != 1 && !this.group) {
            throw new Exception("Can't have a fitness session with more than 1 trainee!");
        }

        this.trainees = trainees;
        for (Customer customer : trainees) {
            customer.train();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isGroup() {
        return group;
    }
}
