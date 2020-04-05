package Main;

public abstract class Food implements iHibernate {
    protected double quality;
    protected double quantity;
    protected int age;
    protected int type;

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
        return "type: " + this.type + ", score: " + this.getFoodScore();
    }


    public double getQuality() {
        return this.quality;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public int getAge() {
        return this.age;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setAge(int age) {
        this.age = age;
    }

}