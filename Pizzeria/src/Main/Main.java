package Main;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {
    ArrayList<Oven> ovens;
    ArrayList<Italian> italians;
    ExecutorService italianThreads;
    ArrayList<Order> orders;
    HashMap<String, Ingredient> ingredients;

    public Main() throws Exception {
        italianThreads = Executors.newCachedThreadPool(); // for adding more italians
        Scanner scanner = new Scanner(System.in); // reading from standard input

        while (true) {
            String[] in = scanner.nextLine().split(", ");

            if (in[0].equals("HirePizzaMan")) {
                italians.add(new Italian(in[1], in[2], Integer.parseInt(in[3]), ovens));
                // HirePizzaMan, <First name>, <Last name>, <year experience>

            } else if (in[0].equals("Oven")) {
                ovens.add(new Oven(Integer.parseInt(in[1])));
                // Oven, <capacity>

            } else if (in[0].equals("Ingredient")) {
                if (ingredients.containsKey(in[1])) {
                    throw new Exception("Error: The ingredient already exists!");
                }
                ingredients.put(in[1], new Ingredient(in[1], in[2]));
                // Ingredient, <Ingredient name>, <Ingredient type>

            } else if (in[0].equals("Order")) {
                // parse input to list of ingredients using the map
                List<Ingredient> ingreds = Arrays.stream(in).skip(2).map(ingredients::get).collect(Collectors.toList());
                orders.add(new Order(Integer.parseInt(in[1]), ingreds));
                // Order, <id>, <Ingredients>

            }
        }
    }

}
