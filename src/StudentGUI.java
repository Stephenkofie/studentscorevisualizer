import org.jfree.chart.ChartPanel;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class StudentGUI {

    private JFrame frame;
    private JTextArea outputArea;
    private JPanel chartPanelContainer;

    private List<Student> students;
    private Map<String, Integer> gradeStats;
    private ChartPanel currentChart;

    public StudentGUI() {

        // ===== FRAME =====
        frame = new JFrame("Student Score Visualizer");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(15, 15));

        // ===== TITLE =====
        JLabel title = new JLabel("📊 Student Score Visualization System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== BUTTONS =====
        JButton uploadBtn = createStyledButton("Upload CSV");
        JButton barChartBtn = createStyledButton("Bar Chart");
        JButton pieChartBtn = createStyledButton("Pie Chart");
        JButton exportBtn = createStyledButton("Export Chart");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(245, 245, 245));

        buttonPanel.add(uploadBtn);
        buttonPanel.add(barChartBtn);
        buttonPanel.add(pieChartBtn);
        buttonPanel.add(exportBtn);

        // ===== TEXT AREA =====
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("📋 Results"));

        // ===== CHART PANEL =====
        chartPanelContainer = new JPanel();
        chartPanelContainer.setPreferredSize(new Dimension(850, 300));
        chartPanelContainer.setBackground(Color.WHITE);
        chartPanelContainer.setBorder(BorderFactory.createTitledBorder("📈 Visualization"));

        // ===== CENTER PANEL =====
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(chartPanelContainer, BorderLayout.SOUTH);

        // ===== ADD TO FRAME =====
        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // ===== ACTIONS =====
        uploadBtn.addActionListener(e -> uploadCSV());

        barChartBtn.addActionListener(e -> {
            if (gradeStats != null) {
                showChart(ChartGenerator.createBarChart(gradeStats));
            } else showMessage("Upload CSV first.");
        });

        pieChartBtn.addActionListener(e -> {
            if (gradeStats != null) {
                showChart(ChartGenerator.createPieChart(gradeStats));
            } else showMessage("Upload CSV first.");
        });

        exportBtn.addActionListener(e -> exportChart());

        frame.setVisible(true);
    }

    // ===== STYLED BUTTON METHOD =====
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setPreferredSize(new Dimension(140, 40));
        return btn;
    }

    // ===== CSV LOAD =====
    private void uploadCSV() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(frame);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            students = CSVReader.readCSV(file.getAbsolutePath());
            gradeStats = GradeCalculator.calculateGrades(students);

            students.sort((s1, s2) -> s2.getScore() - s1.getScore());

            displayResults();
        }
    }

    // ===== DISPLAY RESULTS =====
    private void displayResults() {
        outputArea.setText("");

        outputArea.append("=== Student Ranking ===\n");
        for (int i = 0; i < students.size(); i++) {
            outputArea.append((i + 1) + ". "
                    + students.get(i).getName() + " - "
                    + students.get(i).getScore() + "\n");
        }

        outputArea.append("\n=== Grade Distribution ===\n");
        int total = students.size();

        for (String grade : gradeStats.keySet()) {
            int count = gradeStats.get(grade);
            double percent = (count * 100.0) / total;

            outputArea.append(grade + " : " + count +
                    String.format(" (%.2f%%)", percent) + "\n");
        }

        outputArea.append("\n=== Statistics ===\n");

        double avg = StatisticsCalculator.getAverage(students);
        int highest = StatisticsCalculator.getHighest(students);
        int lowest = StatisticsCalculator.getLowest(students);
        double passRate = StatisticsCalculator.getPassRate(students);

        outputArea.append(String.format("Average Score: %.2f\n", avg));
        outputArea.append("Highest Score: " + highest + "\n");
        outputArea.append("Lowest Score: " + lowest + "\n");
        outputArea.append(String.format("Pass Rate: %.2f%%\n", passRate));

        outputArea.append("\n🏆 Top Student: "
                + students.get(0).getName()
                + " (" + students.get(0).getScore() + ")\n");
    }

    // ===== SHOW CHART =====
    private void showChart(ChartPanel chart) {
        chartPanelContainer.removeAll();
        chart.setPreferredSize(new Dimension(850, 280));

        currentChart = chart;

        chartPanelContainer.add(chart);
        chartPanelContainer.revalidate();
        chartPanelContainer.repaint();
    }

    // ===== EXPORT =====
    private void exportChart() {
        if (currentChart == null) {
            showMessage("No chart to export.");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);

        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();

                org.jfree.chart.ChartUtilities.saveChartAsPNG(
                        file,
                        currentChart.getChart(),
                        800,
                        600
                );

                showMessage("Chart exported successfully!");
            } catch (Exception e) {
                showMessage("Error exporting chart.");
            }
        }
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(frame, msg);
    }
}