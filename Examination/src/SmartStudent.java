public class SmartStudent extends Student {
    public SmartStudent(String name, int num, Whiteboard whiteboard) {
        super(name, num, whiteboard);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Problem nextProblem = whiteboard.getNextSmartProblem(this.solved);
                solveProblem(nextProblem);
                this.solved++;
            } catch (Exception e) {
                return;
            }
        }

    }
}
