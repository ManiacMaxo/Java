package org.elsys.vending;

import java.util.Collection;
import java.util.Map;

public class EspressoVendingMachine {
    private final Map<String, Integer> containers = null;
    private double turnover;

    /*
     * Collection of all ingredients supported by the vending machine.
     */
    public EspressoVendingMachine(Collection<String> containers) {
        for (String iterator : containers) {
            this.containers.put(iterator, 5);
        }
    }

    /*
     * Returns the current turnover from all the sells after last resupply of the
     * vending machine.
     */
    public double getTurnover() {
        return this.turnover;
    }

    public void resupplyContainer(String ingredient) {
    }

    public void resupply() {
        this.turnover = 0;
    }

    public boolean hasEnoughIngredientSupply(String ingredient, int amount) {
        return false;
    }

    public Collection<String> getIngredientContainers() {
        return this.containers.keySet();
    }

    public int getIngredientContainerCapacity(String ingredient) {
        return 5;
    }

    public int getIngredientSupply(String ingredient) {
        if (this.containers.get(ingredient) == null) {
            throw new RuntimeException("vending machine does not contain ingredient!");
        }

        return this.containers.get(ingredient);
    }

    public void useIngredient(String ingredient, int amount) {
        if (this.containers.get(ingredient) == null) {
            throw new RuntimeException("vending machine does not contain ingredient!");
        }

        int ingredientAmount = this.containers.get(ingredient);

        if (ingredientAmount < amount) {
            throw new RuntimeException("not enough ingredients!");
        }

        ingredientAmount -= amount;
        this.containers.put(ingredient, ingredientAmount);
    }

    public void brewRecipe(Recipe recipe) {
        Map<String, Integer> ingredients = recipe.getIngredients();
        for (String iterator : ingredients.keySet()) {
            useIngredient(iterator, ingredients.get(iterator));
        }
    }
}
