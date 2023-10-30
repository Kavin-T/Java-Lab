import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGrading extends JFrame {
    private JTextField nameField, dobField, genderField, addressField, marksField, attendanceField;
    private JComboBox<String> semesterList;
    private JTextArea displayArea;
    private JButton calculateGPAButton;

    public StudentGrading() {
        setTitle("Student Grading System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        nameField = new JTextField(20);
        dobField = new JTextField(20);
        genderField = new JTextField(20);
        addressField = new JTextField(20);
        marksField = new JTextField(20);
        attendanceField = new JTextField(20);

        String[] semesters = {"1", "2", "3", "4", "5", "6", "7", "8"};
        semesterList = new JComboBox<>(semesters);

        JButton displayButton = new JButton("Display");
        JButton searchButton = new JButton("Search");
        calculateGPAButton = new JButton("Calculate GPA");

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("DOB:"));
        inputPanel.add(dobField);
        inputPanel.add(new JLabel("Gender:"));
        inputPanel.add(genderField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Semester:"));
        inputPanel.add(semesterList);
        inputPanel.add(new JLabel("Marks:"));
        inputPanel.add(marksField);
        inputPanel.add(new JLabel("Attendance:"));
        inputPanel.add(attendanceField);
        JPanel buttonPanel=new JPanel(new FlowLayout());
        buttonPanel.add(displayButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(calculateGPAButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        displayButton.addActionListener(e -> displayStudentInfo());
        searchButton.addActionListener(e -> searchStudent());
        calculateGPAButton.addActionListener(e -> calculateGPA());

        setVisible(true);
    }

    private void displayStudentInfo() {
        String info = "Name: " + nameField.getText() + "\n" +
                "DOB: " + dobField.getText() + "\n" +
                "Gender: " + genderField.getText() + "\n" +
                "Address: " + addressField.getText() + "\n" +
                "Semester: " + semesterList.getSelectedItem() + "\n" +
                "Marks: " + marksField.getText() + "\n" +
                "Attendance: " + attendanceField.getText() + "\n";
        displayArea.setText(info);
    }

    private void searchStudent() {
        // Perform search operation
        // Example: Display searched student information in the display area
        displayArea.setText("Searched student information will be displayed here.");
    }

    private void calculateGPA() {
        // Calculate GPA based on entered marks
        try {
            String[] marks = marksField.getText().split(",");
            double totalMarks = 0;
            for (String mark : marks) {
                totalMarks += Double.parseDouble(mark);
            }
            double gpa = totalMarks / marks.length; // Simple average as an example
            displayArea.setText("Calculated GPA: " + gpa);
        } catch (NumberFormatException e) {
            displayArea.setText("Invalid marks format. Please enter marks separated by commas.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentGrading());
    }
}
