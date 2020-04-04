package Main;

public class Main {

    public static void main(String args[]) {
        System.out.println("hello");
        Squirrel sq = new Squirrel("brown", "Bob", 2);
        System.out.println(sq.name);
        Cake cake = new Cake(5, 2);
        sq.addFood(cake);
        sq.passWinter();
        double temp = 5 * (0.1 + 1.99 / Math.pow(2, 1 / 0.85));
        System.out.println(temp);
//        System.out.println(sq.burrow.food.get(0).quality);
//        System.out.println(sq.burrow.food.get(0).quality);
    }
}
