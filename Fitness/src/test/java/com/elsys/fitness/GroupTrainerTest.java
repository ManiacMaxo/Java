package com.elsys.fitness;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.elsys.fitness.util.GroupTrainer;
import org.junit.Test;

import com.elsys.fitness.exception.InvalidSalaryException;
import com.elsys.fitness.exception.TrainingException;

public class GroupTrainerTest {

    @Test(expected = InvalidSalaryException.class)
    public void GroupTrainer_givenNegativeSalary_thenThrowException() throws Exception {
        new GroupTrainer("Ivan", "Ivanov", -5);

        fail();
    }

    @Test(expected = TrainingException.class)
    public void performTraining_givenLessCustomer_thenException() throws Exception {
        GroupTrainer trainer = new GroupTrainer("Ivan", "Ivanov", 10);
        Training training = new Training("fitness", TrainingType.GROUP_TRAINING);
        Card card = new Card();
        Customer customer = new Customer("Petar", "Petrov", card);

        trainer.performTraining(training, customer);

        fail();
    }

    @Test(expected = TrainingException.class)
    public void performTraining_givenWrongTrraining_thenThrowException() throws Exception {
        GroupTrainer trainer = new GroupTrainer("Ivan", "Ivanov", 5);
        Training training = new Training("fitness", TrainingType.FITNESS_TRAINING);
        Card card = new Card();
        Customer customer = new Customer("Petar", "Petrov", card);

        trainer.performTraining(training, customer);

        fail();
    }

    @Test
    public void performTraining_givenTrainingAndCustomers_thenSuccessfulTraining() throws Exception {
        GroupTrainer trainer = new GroupTrainer("Ivan", "Ivanov", 5);
        Training training = new Training("fitness", TrainingType.GROUP_TRAINING);
        Card card = new Card();
        Customer customer = new Customer("Petar", "Petrov", card);
        Card card2 = new Card();
        Customer customer2 = new Customer("Petar", "Petrov", card2);
        Card card3 = new Card();
        Customer customer3 = new Customer("Petar", "Petrov", card3);

        trainer.performTraining(training, customer, customer2, customer3);

        assertTrue(trainer.getTrainedPersons() == 3);
        assertTrue(customer.getTrainings().contains(training));
        assertTrue(customer2.getTrainings().contains(training));
        assertTrue(customer3.getTrainings().contains(training));
    }

}
