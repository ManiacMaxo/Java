package org.elsys.vending;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class MainClass {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        while (!sc.nextLine().equals("END")) {
            String scIngredients = sc.nextLine();
            Collection<String> ingredients = Arrays.asList(scIngredients.split(", "));
            EspressoVendingMachine espressoVM = new EspressoVendingMachine(ingredients);
        }

    }
}
