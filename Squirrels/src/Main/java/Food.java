package Main.java;

public class Food {
    double quality;
    double quantity;
    int age;

    public Food() {
        this.quality = 0;
        this.quantity = 0;
        this.age = 0;
    }

    public Food(double quality, double quantity) {
        this.quality = quality;
        this.quantity = quantity;
        this.age = 0;
    }

    double getFoodScore() {
        return this.quantity * this.quality;
    }

    void passWinter() {}
}
