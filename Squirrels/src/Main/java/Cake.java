package Main.java;
import java.lang.Math;

public class Cake extends  Food {
    void passWinter() {
        this.quantity -= this.quantity * 0.3;
        this.quality = this.quantity * (0.1 + 1.99 / Math.pow(2, this.age / 0.85));
        this.age++;
    }
}
