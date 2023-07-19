package test;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

public class Validador {
    public static void main(String[] args) {
    	JFrame frame = new JFrame("Validación de números en JTextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(10);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Permitir números y un punto decimal
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }

                // Permitir solo un punto decimal
                if (c == '.' && textField.getText().contains(".")) {
                    e.consume();
                }
            }
        });

        frame.getContentPane().add(textField);
        frame.setSize(200, 100);
        frame.setVisible(true);
        }
}
