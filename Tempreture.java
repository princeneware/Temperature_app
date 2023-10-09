import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tempreture {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Temperature Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));

            JLabel celsiusLabel = new JLabel("Celsius:");
            JTextField celsiusField = new JTextField();

            JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
            JTextField fahrenheitField = new JTextField();
            fahrenheitField.setEditable(false);

            JButton convertButton = new JButton("Convert");

            convertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double celsius = Double.parseDouble(celsiusField.getText());
                        double fahrenheit = (celsius * 9 / 5) + 32;
                        fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            panel.add(celsiusLabel);
            panel.add(celsiusField);
            panel.add(fahrenheitLabel);
            panel.add(fahrenheitField);
            panel.add(new JLabel()); // Empty cell for spacing
            panel.add(convertButton);

            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
