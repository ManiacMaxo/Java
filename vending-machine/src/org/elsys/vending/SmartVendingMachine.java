package org.elsys.vending;

import java.util.Collection;
import java.util.HashMap;

public class SmartVendingMachine extends EspressoVendingMachine {
    private HashMap<String, Boolean> calledSupport;

    public SmartVendingMachine(Collection<String> containers) {
        super(containers);
    }

    @Override
    public void brewRecipe(Recipe recipe) {
        HashMap<String, Integer> ingredients = recipe.getIngredients();
        for (String iterator : ingredients.keySet()) {
            Integer amount = ingredients.get(iterator);
            useIngredient(iterator, amount);

            // 20% of max capacity of container and not called support for container
            if (amount < 0.2 * 5 && !calledSupport.get(iterator)) {
                notifySupport();
                calledSupport.put(iterator, true);
            } else { // if refilled then amount > 20%
                calledSupport.put(iterator, false);
            }
        }

    }

    /**
     * Do not change this method.
     */
    public void notifySupport() {
        System.out.println("Support notified!!!");
    }

}
