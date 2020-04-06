package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Squirrel> squirrels = new ArrayList<Squirrel>();


        do { // input of squirrels
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter a squirrel:");
                String input = scanner.nextLine();

                if (input.equals("stop")) {
                    break;
                }

                String[] temp = input.split(" ");
                // name - age - type
                squirrels.add(new Squirrel(temp[0], Integer.parseInt(temp[1]), temp[2]));
            }
        } while (true);
        int i = 0, j = 0;
        do { // input of foods
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter a food:");
                String input = scanner.nextLine();

                if (input.equals("stop")) {
                    for (Squirrel sq : squirrels) {
                        System.out.println(sq.toString());
                        System.out.println(sq.burrow.food.toString());
                    }
                    break;
                }

                String[] temp = input.split(" ");
                switch (temp[0]) {
                    case "Nuts":
                        squirrels.get(i).addFood(new Nuts(Double.parseDouble(temp[1]), Double.parseDouble(temp[2])));
                        break;
                    case "Cake":
                        squirrels.get(i).addFood(new Cake(Double.parseDouble(temp[1]), Double.parseDouble(temp[2])));
                        break;
                    case "McBurger":
                        squirrels.get(i).addFood(new McBurger(Double.parseDouble(temp[1]), Double.parseDouble(temp[2])));
                        break;
                }
                if (squirrels.get(i).getTimesGathered() == 4) {
                    i++;
                }

            }
        } while (true);
    }
}
