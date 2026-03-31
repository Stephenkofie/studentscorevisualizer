import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeCalculator {

    public static Map<String, Integer> calculateGrades(List<Student> students) {

        Map<String, Integer> gradeCount = new HashMap<>();

        gradeCount.put("A", 0);
        gradeCount.put("B", 0);
        gradeCount.put("C", 0);
        gradeCount.put("D", 0);
        gradeCount.put("E", 0);
        gradeCount.put("F", 0);

        for (Student student : students) {

            int score = student.getScore();
            String grade;

            if (score >= 80) grade = "A";
            else if (score >= 70) grade = "B";
            else if (score >= 60) grade = "C";
            else if (score >= 50) grade = "D";
            else if (score >= 40) grade = "E";
            else grade = "F";

            student.setGrade(grade);
            gradeCount.put(grade, gradeCount.get(grade) + 1);
        }

        return gradeCount;
    }
}