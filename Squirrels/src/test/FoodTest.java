package test;

import Main.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTester extends Food {

    public FoodTester(double quality, double quantity) {
        super(quality, quantity);
    }

    @Override
    public void passWinter() {

    }
}

class FoodTest {
    @Test
    void getFoodScore() {
        FoodTester food = new FoodTester(10, 10);
        assertEquals(food.getFoodScore(), 100);

        food = new FoodTester(20, 10);
        assertEquals(food.getFoodScore(), 200);

        food = new FoodTester(10, 20);
        assertEquals(food.getFoodScore(), 200);
    }
}
