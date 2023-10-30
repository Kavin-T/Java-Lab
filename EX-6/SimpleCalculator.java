import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;

    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton, equalsButton;

    private double firstNumber, secondNumber, result;
    private String operator;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        addButton.addActionListener(this);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);

        divideButton = new JButton("/");
        divideButton.addActionListener(this);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);

        clearButton = new JButton("C");
        clearButton.addActionListener(this);

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(addButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subtractButton);
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(divideButton);

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            firstNumber = Double.parseDouble(display.getText());
            display.setText("");
            operator = "+";
        }

        if (e.getSource() == subtractButton) {
            firstNumber = Double.parseDouble(display.getText());
            display.setText("");
            operator = "-";
        }

        if (e.getSource() == multiplyButton) {
            firstNumber = Double.parseDouble(display.getText());
            display.setText("");
            operator = "*";
        }

        if (e.getSource() == divideButton) {
            firstNumber = Double.parseDouble(display.getText());
            display.setText("");
            operator = "/";
        }

        if (e.getSource() == equalsButton) {
            secondNumber = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) {
                        display.setText("Error: Division by zero");
                    } else {
                        result = firstNumber / secondNumber;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
        }

        if (e.getSource() == clearButton) {
            display.setText("");
            firstNumber = 0;
            secondNumber = 0;
            result = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
