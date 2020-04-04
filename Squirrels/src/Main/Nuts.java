package Main;

public class Nuts extends Food {
    public Nuts(double quality, double quantity) {
        super(quality, quantity);
        this.type = 0;
    }

    @Override
    public void passWinter() {
        this.age++;
    }
}
