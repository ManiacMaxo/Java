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

    public String toString() {
        String out = "[";
        for (Food obj : this.food) {
            out += obj.toString() + " | ";
        }
        if (out.length() > 3) {
            out = out.substring(0, out.length() - 3);
        }
        out += "]";
        return out;
    }
}
