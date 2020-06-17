import java.util.ArrayList;
import java.util.List;

public class Teacher {
    String fname;
    String lname;
    Whiteboard whiteboard;
    ArrayList<Student> students;


    public Teacher(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public void setWhiteboard(Whiteboard whiteboard) {
        this.whiteboard = whiteboard;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    void evaluateExam(int studentNumber, List<Problem> solvedProblems) {
        ArrayList<Problem> allProblems = whiteboard.getProblems();
        int allPoints = allProblems.stream().mapToInt(Problem::getPoints).sum(); // get max points
        Student st = (Student) students.stream().filter(student -> student.getNum() == studentNumber); // get student by num
        int points = st.getProblems().stream().mapToInt(Problem::getPoints).sum(); // get points of student


    }
}
