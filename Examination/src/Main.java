import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    ExecutorService students;
    ArrayList<ConsistentStudent> consistentStudents;
    ArrayList<SmartStudent> smartStudents;
    Teacher teacher;
    Whiteboard whiteboard;
    ArrayList<Problem> problems;

    public Main() {
        Scanner scanner = new Scanner(System.in); // reading from standard input
        int num = 0;
        int pr = 0;
        String[] in = scanner.nextLine().split(" ");
        do {
            if (in[0].equals("Teacher")) {
                teacher = new Teacher(in[1], in[2]);
            } else if (in[0].equals("ConsistentStudent")) {
                consistentStudents.add(new ConsistentStudent(in[2] + in[3], Integer.parseInt(in[1]), whiteboard));
                num++;
            } else if (in[0].equals("SmartStudent")) {
                smartStudents.add(new SmartStudent(in[2] + in[3], Integer.parseInt(in[1]), whiteboard));
                num++;
            } else if (in[0].equals("Problem")){
                problems.add(new Problem(pr++, Integer.parseInt(in[1]), in[2]);
            }
            in = scanner.nextLine().split(" ");
        } while (!in[0].equals("STRING"));

        students = Executors.newFixedThreadPool(num);
    }
}
