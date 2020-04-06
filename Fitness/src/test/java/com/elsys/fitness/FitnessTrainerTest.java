package com.elsys.fitness;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.elsys.fitness.exception.InvalidSalaryException;
import com.elsys.fitness.exception.TrainingException;

public class FitnessTrainerTest {

    @Test(expected = InvalidSalaryException.class)
    public void fitnessTrainer_givenNegativeSalary_thenThrowException() throws Exception {
        new FitnessTrainer("Ivan", "Ivanov", -5);

        fail();
    }

    @Test
    public void performTraining_givenTrainingAndCustomer_thenSuccessfulTraining() throws Exception {
        FitnessTrainer trainer = new FitnessTrainer("Ivan", "Ivanov", 10);
        Training training = new Training("fitness", TrainingType.FITNESS_TRAINING);
        Card card = new Card();
        Customer customer = new Customer("Petar", "Petrov", card);

        trainer.performTraining(training, customer);

        assertTrue(trainer.getTrainedPersons() == 1);
        assertTrue(customer.getTrainings().size() == 1);
        assertTrue(customer.getTrainings().contains(training));
        assertTrue(customer.getCard().getRemainingTrainings() == Card.DEFAULT_TRAININGS_COUNT - 1);
    }

    @Test
    public void performTraining_givenWrongTrraining_thenThrowException() throws Exception {
        FitnessTrainer trainer = new FitnessTrainer("Ivan", "Ivanov", 5);
        Training training = new Training("fitness", TrainingType.GROUP_TRAINING);
        Card card = new Card();
        Customer customer = new Customer("Petar", "Petrov", card);

        try {
            trainer.performTraining(training, customer);
        } catch (TrainingException e) {
            assertTrue(e.getMessage().equals("Fitness trainers can perform only fitness trainings"));
            return;
        }

        fail();
    }

    @Test
    public void performTraining_givenMoreCustomers_thenThrowException() throws Exception {
        FitnessTrainer trainer = new FitnessTrainer("Ivan", "Ivanov", 5);
        Training training = new Training("fitness", TrainingType.FITNESS_TRAINING);
        Card card = new Card();
        Customer customer = new Customer("Petar", "Petrov", card);
        Card card2 = new Card();
        Customer customer2 = new Customer("Petar", "Petrov", card2);

        try {
            trainer.performTraining(training, customer, customer2);
        } catch (TrainingException e) {
            assertTrue(e.getMessage().equals("Only one customer can attend fitness training"));
            return;
        }

        fail();
    }

}
