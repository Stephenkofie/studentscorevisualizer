# 📊 Student Score Visualization System

## 📌 Overview

The **Student Score Visualization System** is a Java-based application designed to analyze and visualize student examination scores.

It allows users to upload a CSV file containing student data, processes the information, and presents insights such as grade distribution, rankings, and statistical summaries using graphical charts.

---

## 🎯 Objectives

- Analyze student performance data efficiently  
- Classify scores into grades (A–F)  
- Generate statistical insights (average, highest, lowest, pass rate)  
- Visualize data using charts (Bar Chart & Pie Chart)  
- Provide a user-friendly graphical interface  

---

## ✨ Features

- 📂 **CSV File Upload** – Load student data from external files  
- 🧮 **Automatic Grade Calculation** – Assign grades based on score ranges  
- 🏆 **Student Ranking** – Sort students from highest to lowest score  
- 📊 **Data Visualization** – Generate:
  - Bar Charts  
  - Pie Charts  
- 📈 **Statistical Analysis**:
  - Average score  
  - Highest score  
  - Lowest score  
  - Pass rate  
- 💾 **Export Feature** – Save charts as PNG images  
- 🖥️ **Graphical User Interface (GUI)** using Java Swing  

---

## 🛠️ Tech Stack

- **Programming Language:** Java  
- **GUI Framework:** Java Swing  
- **Chart Library:** JFreeChart  
- **Data Handling:** CSV (BufferedReader)  
- **IDE:** VS Code  

---

## 📂 Project Structure
# 📊 Student Score Visualization System

## 📌 Overview

The **Student Score Visualization System** is a Java-based application designed to analyze and visualize student examination scores.

It allows users to upload a CSV file containing student data, processes the information, and presents insights such as grade distribution, rankings, and statistical summaries using graphical charts.

---

## 🎯 Objectives

- Analyze student performance data efficiently  
- Classify scores into grades (A–F)  
- Generate statistical insights (average, highest, lowest, pass rate)  
- Visualize data using charts (Bar Chart & Pie Chart)  
- Provide a user-friendly graphical interface  

---

## ✨ Features

- 📂 **CSV File Upload** – Load student data from external files  
- 🧮 **Automatic Grade Calculation** – Assign grades based on score ranges  
- 🏆 **Student Ranking** – Sort students from highest to lowest score  
- 📊 **Data Visualization** – Generate:
  - Bar Charts  
  - Pie Charts  
- 📈 **Statistical Analysis**:
  - Average score  
  - Highest score  
  - Lowest score  
  - Pass rate  
- 💾 **Export Feature** – Save charts as PNG images  
- 🖥️ **Graphical User Interface (GUI)** using Java Swing  

---

## 🛠️ Tech Stack

- **Programming Language:** Java  
- **GUI Framework:** Java Swing  
- **Chart Library:** JFreeChart  
- **Data Handling:** CSV (BufferedReader)  
- **IDE:** VS Code  

---

## 📂 Project Structure
```
src/
│
├── Main.java # Entry point of the application
├── Student.java # Student data model
├── CSVReader.java # Reads CSV file
├── GradeCalculator.java # Assigns grades
├── StatisticsCalculator.java # Computes statistics
├── ChartGenerator.java # Generates charts
└── StudentGUI.java # User interface
```

---


---

## ⚙️ How It Works

1. User uploads a CSV file  
2. The system reads the file using `CSVReader`  
3. Student objects are created  
4. Grades are assigned using `GradeCalculator`  
5. Statistics are computed using `StatisticsCalculator`  
6. Charts are generated using `ChartGenerator`  
7. Results are displayed in the GUI  


---

## 🚀 Installation & Usage

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Stephenkofie/studentscorevisualizer.git
cd StudentScoreVisualizer
```

### 2️⃣ Add Required Libraries

Download JFreeChart library
Place .jar files inside a lib/ folder

### 3️⃣ Compile the Project

```bash
javac -cp "lib/*" src/*.java
```

### 4️⃣ Run the Application

```bash
java -cp "lib/*;src" Main
```

### 5️⃣ Use the App

Click Upload CSV
Select your dataset
View results and charts
Export chart if needed

---

## 🧠 Concepts Used
- Object-Oriented Programming (OOP)
- File Handling (CSV Reading)
- Collections (List, Map)
- GUI Development (Swing)
- Data Visualization

## ⚠️ Challenges Faced
- Handling external library (JFreeChart) integration
- Resolving IDE classpath issues
- Designing a clean and responsive UI

## 🔮 Future Improvements
- Multi-subject support
- Database integration
- Advanced analytics
- Web-based version

## 👨‍💻 Author
Stephen Kofie Korh
Data Science and Analytics
University of Mines and Technology
