import java.util.ArrayList;

public abstract class Student implements Runnable {
    private String name;
    private int num;
    private ArrayList<Problem> problems;
    protected Whiteboard whiteboard;
    protected int solved;

    public Student(String name, int num, Whiteboard whiteboard) {
        this.name = name;
        this.num = num;
        this.whiteboard = whiteboard;
        this.solved = 0;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public int getSolved() {
        return solved;
    }

    public void solveProblem(Problem problem) throws InterruptedException {
        Thread.sleep((long) (problem.getPoints() *1000* problem.getComplexity()));
    }


}
