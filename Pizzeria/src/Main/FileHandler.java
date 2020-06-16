package Main;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public static synchronized void write(String input) {
        try {
            FileWriter myWriter = new FileWriter("logger.txt");
            myWriter.write(input);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error when writing in file.");
            e.printStackTrace();
        }
    }

}
