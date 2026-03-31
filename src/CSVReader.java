import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Student> readCSV(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String id = values[0];
                String name = values[1];
                int score = Integer.parseInt(values[2]);

                students.add(new Student(id, name, score));
            }

        } catch (Exception e) {
            System.out.println("Error reading CSV file.");
        }

        return students;
    }
}
