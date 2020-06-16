package Main;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Executor;

public class Italian implements Runnable {
    private String fname;
    private String lname;
    private String position;
    private long time;
    private Order order;
    private int experience;
    private ArrayList<Oven> ovens;
    private Executor thread;

    public Italian(String fname, String lname, int experience, ArrayList<Oven> ovens) throws Exception {
        if (experience < 0) {
            throw new Exception("Experience cannot be less than 0");
        }
        this.fname = fname;
        this.lname = lname;
        this.experience = experience;

        if (this.experience < 4) {
            this.time = 1000;
            this.position = "JuniorItalian";
        } else if (this.experience < 9) {
            this.time = 500;
            this.position = "Italian";
        } else {
            this.time = 300;
            this.position = "SeniorItalian";
        }

        this.ovens = ovens;
    }

    public String getPosition() {
        return position;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        synchronized (this) {
            this.notify();
        }
    }

    Oven getOven() { // find first empty oven
        Optional<Oven> out;
        do {
            out = ovens.stream().filter(o -> o.isFree()).findFirst();
        } while (out.isEmpty()); // continue searching if none is found
        return out.get(); // parse to class Oven
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            FileHandler.write("Started preparing order " + this.order.getId());
            try {
                Thread.sleep(this.time * this.order.getIngredients().size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FileHandler.write("Finished preparing order " + this.order.getId());
            getOven().bake(this.order);
            this.order = null;
        }
    }
}
