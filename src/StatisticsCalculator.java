import java.util.List;

public class StatisticsCalculator {

    public static double getAverage(List<Student> students) {
        int sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return (double) sum / students.size();
    }

    public static int getHighest(List<Student> students) {
        int max = Integer.MIN_VALUE;
        for (Student s : students) {
            if (s.getScore() > max) {
                max = s.getScore();
            }
        }
        return max;
    }

    public static int getLowest(List<Student> students) {
        int min = Integer.MAX_VALUE;
        for (Student s : students) {
            if (s.getScore() < min) {
                min = s.getScore();
            }
        }
        return min;
    }

    public static double getPassRate(List<Student> students) {
        int pass = 0;
        for (Student s : students) {
            if (s.getScore() >= 50) {
                pass++;
            }
        }
        return (pass * 100.0) / students.size();
    }
}