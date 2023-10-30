import java.awt.*;
import javax.swing.*;

public class StudentGradingSystem extends JFrame {
    private JTextField nameField, dobField, genderField, addressField;
    private JComboBox<String> semesterComboBox;
    private JTextField[] subjectsFields = new JTextField[5];

    public StudentGradingSystem() {
        setTitle("Student Grading System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nameLabel = new JLabel("Name:");
        JLabel dobLabel = new JLabel("Date of Birth:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel semNoLabel = new JLabel("Semester No:");
        nameField = new JTextField(20);
        dobField = new JTextField(20);
        genderField = new JTextField(20);
        addressField = new JTextField(20);
        String[] semesterNumbers = {"1", "2", "3", "4", "5", "6", "7", "8"};
        semesterComboBox = new JComboBox<>(semesterNumbers);
        for (int i = 0; i < 5; i++) {
            subjectsFields[i] = new JTextField(20);
        }
        JButton displayButton = new JButton("Display");
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        JPanel buttonPanel = new JPanel();
        JPanel displayPanel = new JPanel();
        displayPanel.add(new JTextArea(40,30));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(semNoLabel);
        inputPanel.add(semesterComboBox);
        for (int i = 0; i < 5; i++) {
            inputPanel.add(new JLabel("Subject " + (i + 1)));
            inputPanel.add(subjectsFields[i]);
        }
        buttonPanel.add(displayButton);
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
        StudentGradingSystem gradingSystem=new StudentGradingSystem();
    }
}
