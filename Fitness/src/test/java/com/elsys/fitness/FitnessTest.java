package com.elsys.fitness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.elsys.fitness.exception.CardException;
import com.elsys.fitness.exception.FitnessException;
import com.elsys.fitness.exception.NoCardsAvailableException;

public class FitnessTest {

    @After
    public void cleanUp() {
        Fitness.availableCards = new ArrayList<Card>();
        Fitness.fitnessTrainers = new ArrayList<>();
        Fitness.groupTrainers = new ArrayList<>();
        Fitness.registerEmployees = new ArrayList<>();
    }

    @Test
    public void registerNewCards_given10CardsToRegister_then10CardsAreRegisteres() throws CardException {
        Fitness.registerNewCards(10);

        assertTrue(Fitness.availableCards.size() == 10);
    }

    @Test
    public void hireEmployee_givenFitnessTrainer_thenFitnessTrainerIsAdded() throws Exception {
        Fitness.hireEmployee("Ivan", "Ivanov", EmployeeType.FITNESS_TRAINER);

        assertTrue(Fitness.fitnessTrainers.size() == 1);
    }

    @Test
    public void hireEmployee_givenGroupTrainer_thenGroupTrainerIsAdded() throws Exception {
        Fitness.hireEmployee("Ivan", "Ivanov", EmployeeType.GROUP_TRAINER);

        assertTrue(Fitness.groupTrainers.size() == 1);
    }

    @Test
    public void hireEmployee_givenRegisterEmployee_thenRegisterEmpoyeeIsAdded() throws Exception {
        Fitness.hireEmployee("Ivan", "Ivanov", EmployeeType.REGISTER_EMPLOYEE);

        assertTrue(Fitness.registerEmployees.size() == 1);
    }

    @Test(expected = NoCardsAvailableException.class)
    public void registerCustomer_givenNoCardsAvailable_thenException() throws Exception {
        Fitness.hireEmployee("Ivan", "Ivanov", EmployeeType.REGISTER_EMPLOYEE);

        Fitness.registerCustomer("Petkan", "Petkanov");

        fail();
    }

    @Test(expected = FitnessException.class)
    public void registerCustomer_givenNoRegisterEmployeesAreAvailable_thenException() throws Exception {
        Fitness.registerEmployees = new ArrayList<>();

        Fitness.registerCustomer("Petkan", "Petkanov");

        fail();
    }

    @Test
    public void registerCustomer_givenEverythingIsAvailable_thenSucces() throws Exception {
        Fitness.registerEmployees = new ArrayList<>();
        Fitness.availableCards = new ArrayList<>();
        Fitness.registerNewCards(10);
        Fitness.hireEmployee("Ivanka", "Ivankova", EmployeeType.REGISTER_EMPLOYEE);

        Fitness.registerCustomer("Petkan", "Petkanov");

        assertEquals(Fitness.availableCards.size(), 9);
    }

    @Test
    public void performTraining_givenEverythingIsAvailable_thenRemainingTrainingsDecreased() throws Exception {
        Fitness.registerNewCards(10);
        Fitness.hireEmployee("Ivanka", "Ivankova", EmployeeType.REGISTER_EMPLOYEE);
        Fitness.hireEmployee("Ivan", "Ivan", EmployeeType.FITNESS_TRAINER);

        Customer customer = Fitness.registerCustomer("Petkan", "Petkanov");

        Fitness.performTraining("test", TrainingType.FITNESS_TRAINING, customer);

        assertEquals(Fitness.availableCards.size(), 9);
    }

    @Test(expected = FitnessException.class)
    public void performTraining_givenNoFitnessTrainerAvailable_thenException() throws Exception {
        Fitness.registerNewCards(10);
        Fitness.hireEmployee("Ivanka", "Ivankova", EmployeeType.REGISTER_EMPLOYEE);

        Customer customer = Fitness.registerCustomer("Petkan", "Petkanov");

        Fitness.performTraining("test", TrainingType.FITNESS_TRAINING, customer);

        fail();
    }

    @Test(expected = FitnessException.class)
    public void performTraining_givenNoGroupTrainerAvailable_thenException() throws Exception {
        Fitness.registerNewCards(10);
        Fitness.hireEmployee("Ivanka", "Ivankova", EmployeeType.REGISTER_EMPLOYEE);
        Customer customer = Fitness.registerCustomer("Petkan", "Petkanov");

        Fitness.performTraining("test", TrainingType.GROUP_TRAINING, customer);

        fail();
    }

    @Test
    public void orderFitnessTrainers_givenFitnessAndGroupTrainers_thenCorrectOrder() throws Exception {
        Fitness.fitnessTrainers = new ArrayList<>();
        Fitness.groupTrainers = new ArrayList<>();

        Fitness.hireEmployee("Ivan", "Ivan", EmployeeType.FITNESS_TRAINER);
        Fitness.hireEmployee("Petkan", "Petkan", EmployeeType.GROUP_TRAINER);
        Fitness.hireEmployee("Ivanka", "Ivankova", EmployeeType.REGISTER_EMPLOYEE);

        Fitness.registerNewCards(10);
        Customer customer1 = Fitness.registerCustomer("Customer 1", "Customer 1");
        Customer customer2 = Fitness.registerCustomer("Customer 2", "Customer 2");
        Customer customer3 = Fitness.registerCustomer("Customer 3", "Customer 3");
        Customer customer4 = Fitness.registerCustomer("Customer 4", "Customer 4");

        Fitness.performTraining("t1", TrainingType.FITNESS_TRAINING, customer1);
        Fitness.performTraining("21", TrainingType.GROUP_TRAINING, customer2, customer3, customer4);

        List<Trainer> orderFitnessTrainers = Fitness.orderFitnessTrainers();

        assertTrue(orderFitnessTrainers.size() == 2);
        Trainer trainer1 = orderFitnessTrainers.get(0);
        Trainer trainer2 = orderFitnessTrainers.get(1);
        assertTrue(trainer1.getTrainedPersons() == 3);
        assertTrue(trainer2.getTrainedPersons() == 1);
    }

}
