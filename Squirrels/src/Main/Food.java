package Main;

public abstract class Food implements iHibernate {
    double quality;
    double quantity;
    int age;
    int type;

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

    public double getFoodScore() {
        return this.quantity * this.quality;
    }

    public String toString() {
        return "type: " + this.type +  ", score: " + this.getFoodScore();
    }
}