package com.elsys.fitness;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.elsys.fitness.exception.CardException;

public class CardTest {

    @Test
    public void card_givenPositiveAmountOfTrainings_thenCorrectCard() throws CardException {
        Card card = new Card(10);

        assertTrue(card.getCardNumber().trim().length() > 0);
        assertTrue(card.getRemainingTrainings() == 10);
    }

    @Test(expected = CardException.class)
    public void setValidTo_givenNegativeTrainings_thenException() throws CardException {
        new Card(-5);
        
        fail();
    }
}
