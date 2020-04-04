package Main;

import java.util.ArrayList;

public class Burrow {
    ArrayList<Food> food;

    public Burrow() {
        food = new ArrayList<Food>();
    }

    public double getTotalFoodScore() {
        double total = 0;
        for (Food obj : this.food) {
            total += obj.getFoodScore();
        }
        return total;
    }

    public void passWinter() {
        System.out.println("----Winter passes----");
        for (Food obj : this.food) {
            obj.passWinter();
        }

    }

}
