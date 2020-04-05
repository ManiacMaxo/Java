package Main;

public class Squirrel {
    String type;
    String name;
    int age;
    Burrow burrow;
    int times_gathered;

    public Squirrel() {
        this.type = "brown";
        this.name = "Default";
        this.age = 0;
        this.burrow = new Burrow();
        this.times_gathered = 0;
    }

    public Squirrel(String name, int age, String type) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.burrow = new Burrow();
        this.times_gathered = 0;
    }

    public String toString() {
        return "<" + this.type + "> " + this.name + "(" + this.age + ")\n" + this.burrow.toString();
    }

    void addFood(Food food) throws Exception {
        if (this.times_gathered == 4) {
            throw new Exception("Too many gatherings!");
        }
        burrow.food.add(food);
        this.times_gathered++;
    }

    void passWinter() {
        this.times_gathered = 0;
        this.age++;
        for (Food obj : burrow.food) {
            obj.passWinter();
        }
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
