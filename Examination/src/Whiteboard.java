import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Whiteboard {
    private ArrayList<Problem> problems;

    public Whiteboard(ArrayList<Problem> problems) {
        this.problems = problems;
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public Problem getNextConsistentProblem(int previousProblemNumber) throws NoMoreProblemsException {
        if (previousProblemNumber == problems.size()) {
            throw new NoMoreProblemsException();
        }
        if (previousProblemNumber == 0) {
            previousProblemNumber--;
        }
        Collections.sort(problems);
        return problems.get(previousProblemNumber + 1);
    }

    public Problem getNextSmartProblem(int previousProblemNumber) throws NoMoreProblemsException {

        if (previousProblemNumber == problems.size()) {
            throw new NoMoreProblemsException();
        }
        if (previousProblemNumber == 0) {
            previousProblemNumber--;
        }
        // sort by point descending and return next problem
        return problems.stream().sorted(Comparator.comparingInt(Problem::getPoints).reversed())
                .collect(Collectors.toList()).get(previousProblemNumber + 1);
    }
}
