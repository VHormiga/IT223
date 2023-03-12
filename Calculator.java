
package basiccalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField num1Field, num2Field, resultField;
    private JLabel num1Label, num2Label, resultLabel;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        num1Label = new JLabel("Number 1:");
        num2Label = new JLabel("Number 2:");
        resultLabel = new JLabel("Result:");

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        JPanel numPanel = new JPanel(new GridLayout(3, 2));
        numPanel.add(num1Label);
        numPanel.add(num1Field);
        numPanel.add(num2Label);
        numPanel.add(num2Field);
        numPanel.add(resultLabel);
        numPanel.add(resultField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        getContentPane().add(numPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            if (e.getSource() == addButton) {
                resultField.setText(Double.toString(num1 + num2));
            } else if (e.getSource() == subtractButton) {
                resultField.setText(Double.toString(num1 - num2));
            } else if (e.getSource() == multiplyButton) {
                resultField.setText(Double.toString(num1 * num2));
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    resultField.setText("Error: Cannot divide by zero");
                } else {
                    resultField.setText(Double.toString(num1 / num2));
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator calculator = new Calculator();
                calculator.setVisible(true);
            }
        });
    }
}
