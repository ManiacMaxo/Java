import java.util.Comparator;

public class Problem implements Runnable, Comparable<Problem> {
    private int num;
    private int points;
    private Complexity complexity;

    public Problem(int num, int points, Complexity complexity) {
        this.num = num;
        this.points = points;
        this.complexity = complexity;
    }

    public int getNum() {
        return num;
    }

    public int getPoints() {
        return points;
    }

    public double getComplexity() {
        if (this.complexity == Complexity.LOW) {
            return 0.5;
        } else if (this.complexity == Complexity.MEDIUM) {
            return 1;
        } else return 1.5;
    }

    @Override
    public void run() {

    }

    @Override
    public int compareTo(Problem p) {
        return this.num;
    }
}
