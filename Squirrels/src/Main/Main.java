package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Squirrel> squirrels = new ArrayList<Squirrel>();

        Squirrel sq = new Squirrel();

        sq.addFood(new Cake(7, 2));
        sq.addFood(new McBurger(10, 1));
        sq.addFood(new Nuts(3, 8));
        sq.addFood(new Cake(1, 2));
        sq.addFood(new Cake(1, 2));

        System.out.println(sq.toString());

//        do {
//            try (Scanner scanner = new Scanner(System.in)) {
//                System.out.println("Enter a squirrel:");
//                String input = scanner.nextLine();
//                if (input.equals("stop")) {
//                    break;
//                }
//                String[] temp = input.split(" ");
//                String name = temp[0];
//                int age = Integer.parseInt(temp[1]);
//                String type = temp[2];
//                squirrels.add(new Squirrel(name, age, type));
//            }
//        } while (true);
//
//        do {
//            try (Scanner scanner = new Scanner(System.in)) {
//                System.out.println("Enter a food:");
//                String input = scanner.nextLine();
//                if (input.equals("stop")) {
//                    for (Squirrel obj : squirrels) {
//                        System.out.println(obj.toString());
//                        System.out.println(obj.burrow.food.toString());
//                    }
//                    break;
//                }
//                String[] temp = input.split(" ");
//
//
//            }
//        } while (true);
    }
}
