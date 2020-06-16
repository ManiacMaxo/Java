package Main;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long time;
    private int id;
    private ArrayList<Ingredient> ingredients = null;

    public Order(int id, List<Ingredient> ingredients) throws Exception {
        int[] counter = {0, 0, 0, 0, 0};
        for (Ingredient ingredient : ingredients) {
            String type = ingredient.getType();
            switch (type) {
                case "dough" -> {
                    if (counter[0] == 1) {
                        throw new Exception("cannot have more than one dough in a pizza");
                    }
                    counter[0]++;
                    time += 2000;
                }
                case "sauce" -> {
                    if (counter[1] == 2) {
                        throw new Exception("cannot have more than two sauces on a pizza");
                    }
                    time += counter[2] > 1 ? 100 : 1000;
                    counter[1]++;
                }
                case "vegetable" -> {
                    time += counter[2] > 1 ? 50 : 500;
                    counter[2]++;
                }
                case "cheese" -> {
                    time += counter[3] > 1 ? 100 : 1000;
                    counter[3]++;
                }
                case "meat" -> {
                    time += counter[4] > 1 ? 150 : 1500;
                    counter[4]++;
                }
            }
            this.ingredients.add(ingredient);
        }
        if (counter[0] == 0 || counter[1] == 0 || counter[3] == 0) {
            throw new Exception("pizza must have at least one dough, one sauce and one cheese");
        }

    }

    public long getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

}
