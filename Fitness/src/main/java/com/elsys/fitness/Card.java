package com.elsys.fitness;

import java.util.UUID;

public class Card {
    String number;
    int sessions;

    public Card() {
        this.number = UUID.randomUUID().toString();
        this.sessions = 10;
    }

    public String getCardNumber() {
        return number;
    }

    public int getRemainingTrainings() {
        return sessions;
    }

    void train() throws Exception {
        if (this.sessions == 0) {
            throw new Exception("No sessions left on card");
        }
        this.sessions--;
    }
}
