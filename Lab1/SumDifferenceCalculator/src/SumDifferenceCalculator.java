import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumDifferenceCalculator extends JFrame {

    private JTextField number1Field;
    private JTextField number2Field;
    private JTextField resultField;
    private JButton addButton;
    private JButton subtractButton;

    public SumDifferenceCalculator() {
        // Create the frame
        setTitle("Sum and Difference Calculator");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Create the text fields
        number1Field = new JTextField();
        number2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        // Create the buttons
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");

        // Add action listeners to buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAddition();
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSubtraction();
            }
        });

        // Add components to the frame
        add(new JLabel("Number 1:"));
        add(number1Field);
        add(new JLabel("Number 2:"));
        add(number2Field);
        add(addButton);
        add(subtractButton);
        add(new JLabel("Result:"));
        add(resultField);

        // Set the frame to be visible
        setVisible(true);
    }

    private void performAddition() {
        try {
            int num1 = Integer.parseInt(number1Field.getText());
            int num2 = Integer.parseInt(number2Field.getText());
            int sum = num1 + num2;
            resultField.setText(String.valueOf(sum));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid integers.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performSubtraction() {
        try {
            int num1 = Integer.parseInt(number1Field.getText());
            int num2 = Integer.parseInt(number2Field.getText());
            int difference = num1 - num2;
            resultField.setText(String.valueOf(difference));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid integers.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create and display the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SumDifferenceCalculator();
            }
        });
    }
}
