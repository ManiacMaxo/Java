package Main;

public class Cake extends Food {
    public Cake(double quality, double quantity) {
        super(quality, quantity);
        this.type = 1;
    }

    @Override
    public void passWinter() {
        this.quantity -= (this.quantity * 0.3);
        this.quality *= 0.1 + (1.99 / Math.pow(2, this.age / 0.85));
        this.age++;
    }
}
