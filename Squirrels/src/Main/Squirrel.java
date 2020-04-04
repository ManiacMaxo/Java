package Main;

public class Squirrel {
    String type;
    String name;
    int age;
    Burrow burrow;

    public Squirrel() {
        this.type = "brown";
        this.name = "Default";
        this.age = 0;
        this.burrow = new Burrow();
    }

    public Squirrel(String type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.burrow = new Burrow();
    }

    public String toString() {
        return "<" + this.type + "> " + this.name + "(" + this.age + ")";
    }

    void addFood(Food food) {
        burrow.food.add(food);
    }

    void passWinter() {
        for (Food obj : burrow.food) {
            obj.passWinter();
        }
    }

}
