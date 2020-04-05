package Main;

public class McBurger extends Food {
    public McBurger(double quality, double quantity) {
        super(quality, quantity);
        this.type = 2;
    }

    @Override
    public void passWinter() {
        this.age++;
        if (this.age == 1) {
            this.quality -= this.quality * 0.5;
            this.quantity -= this.quantity * 0.2;
        }
    }
}
