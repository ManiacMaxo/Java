import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> otherNumbers = new LinkedList<Integer>();

        numbers.add(16);
        numbers.add(75);
        numbers.add(34);

        printList(numbers);
    }

    static void printList(List<Integer> list) {
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
