package com.elsys.fitness;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.elsys.fitness.exception.NoCardsAvailableException;

public class RegisterTest {

    @Test(expected = NoCardsAvailableException.class)
    public void registerCustomer_givenNoCardsAvailable_thenException() throws Exception {
        Fitness.availableCards = new ArrayList<Card>();
        Register register = new Register("Pesho", "Peshov", 10);

        register.registerCustomer("Ivan", "Ivanov");

        fail();
    }

    @Test
    public void registerCustomer_givenAvailableCards_thenNewCustomerAdded() throws Exception {
        Card card = new Card();
        Fitness.availableCards = new ArrayList<Card>();
        Fitness.availableCards.add(card);
        Register register = new Register("Pesho", "Peshov", 10);

        register.registerCustomer("Ivan", "Ivanov");

        assertTrue(Fitness.customers.containsKey(card.getCardNumber()));
    }

}
