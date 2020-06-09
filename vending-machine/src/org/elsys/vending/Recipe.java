package org.elsys.vending;

import java.util.HashMap;

public class Recipe {
    private final double price;
    private final String name;
    private HashMap<String, Integer> ingredients;

    public Recipe(String name, double price) {
        this.name = name;
        if (price < 0) {
            throw new RuntimeException("price cannot be negative!");
        }
        this.price = price;

    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    /*
     * Should add an ingredient into the recipe. If given ingredient is added
     * twice a RuntimeException should be thrown.
     */
    public void addIngredient(String name, int amount) throws Exception {
        if (this.ingredients.containsKey(name)) {
            throw new Exception("ingredient already in recipe!");
        }
        this.ingredients.put(name, amount);
    }

    /*
     * Should return a copy of the ingredients in the recipe.
     */
    public HashMap<String, Integer> getIngredients() {
        return this.ingredients;
    }
}
