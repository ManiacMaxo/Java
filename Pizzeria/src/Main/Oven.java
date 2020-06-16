package Main;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Oven {
    private Executor threadPool;
    private int capacity;
    private int occupied;

    public Oven(int capacity) {
        this.occupied = 0;
        this.capacity = capacity;
        this.threadPool = Executors.newFixedThreadPool(this.capacity);
    }

    boolean isFree() {
        return this.capacity > this.occupied;
    }

    public void bake(Order order) {
        synchronized (this) {
            this.occupied++;
        }
        threadPool.execute(() -> {
            FileHandler.write("Started baking pizza " + order.getId());

            try {
                Thread.sleep(order.getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            FileHandler.write("Finished baking pizza " + order.getId());
            FileHandler.write("Preparing order " + order.getId());
            synchronized (this) {
                this.occupied--;
            }
        });
    }
}
