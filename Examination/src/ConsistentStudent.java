public class ConsistentStudent extends Student {
    public ConsistentStudent(String name, int num, Whiteboard whiteboard) {
        super(name, num, whiteboard);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Problem nextProblem = whiteboard.getNextConsistentProblem(this.solved);
                solveProblem(nextProblem);
                this.solved++;
            } catch (Exception e) {
                return;
            }
        }
    }
}
