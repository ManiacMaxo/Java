package Main.java;

public class Squirrel {
    String name = "default";
    int age = 0;
    String type;
    Burrow burrow = new Burrow();

    public Squirrel(String name, String type, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "<" + this.type + ">" + this.name + "(" + this.age + ")" ;
    }

    void addFood(Food food) {
        burrow.food.add(food);
    }

    void passWinter() {
        for(Food obj: burrow.food) {
            obj.passWinter();
        }
    }

    double getTotalFoodScore() {
        double total = 0;
        for(Food obj: burrow.food) {
            total += obj.getFoodScore();
        }
        return total;
    }
}
