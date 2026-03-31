import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

import java.util.List;
import java.util.Map;

public class ChartGenerator {

    // BAR CHART
    public static ChartPanel createBarChart(Map<String, Integer> gradeStats) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String grade : gradeStats.keySet()) {
            dataset.addValue(gradeStats.get(grade), "Students", grade);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Grade Distribution",
                "Grades",
                "Number of Students",
                dataset
        );

        return new ChartPanel(chart);
    }

    // PIE CHART
    public static ChartPanel createPieChart(Map<String, Integer> gradeStats) {

        DefaultPieDataset dataset = new DefaultPieDataset();

        for (String grade : gradeStats.keySet()) {
            dataset.setValue(grade, gradeStats.get(grade));
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Grade Distribution (Pie Chart)",
                dataset,
                true,
                true,
                false
        );

        return new ChartPanel(chart);
    }

    // HISTOGRAM (uses raw scores)
    public static ChartPanel createHistogram(List<Student> students) {

        HistogramDataset dataset = new HistogramDataset();

        double[] scores = new double[students.size()];

        for (int i = 0; i < students.size(); i++) {
            scores[i] = students.get(i).getScore();
        }

        dataset.addSeries("Scores", scores, 5);

        JFreeChart chart = ChartFactory.createHistogram(
                "Score Distribution",
                "Score Range",
                "Frequency",
                dataset,
                PlotOrientation.VERTICAL,
                true,   // legend
                true,   // tooltips
                false   // URLs
        );

        return new ChartPanel(chart);
    }
}