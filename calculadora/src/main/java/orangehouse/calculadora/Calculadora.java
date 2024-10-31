/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package orangehouse.calculadora;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField num1Field, num2Field, resultadoField;
    private JButton sumaButton, restaButton, multButton, divButton;

    public Calculadora()
 {
        setTitle("Calculadora Simple");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4, 20, 20)); // 5 rows, 2 columns, 10px horizontal and vertical gaps

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultadoField = new JTextField();
        resultadoField.setEditable(false);
        sumaButton = new JButton("+");
        restaButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");


        // Adding components with spacing and alignment
        add(new JLabel("Número 1:"));
        add(num1Field);
        add(new JLabel("Número 2:"));
        add(num2Field);
        add(sumaButton);
        add(restaButton);
        add(multButton);
        add(divButton);
        add(new JLabel("Resultado:"));
        add(resultadoField);

        sumaButton.addActionListener(this);
        restaButton.addActionListener(this);
        multButton.addActionListener(this);
        divButton.addActionListener(this);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double resultado = 0;

            if (e.getSource() == sumaButton) {
                resultado = num1 + num2;
            } else if (e.getSource() == restaButton) {
                resultado = num1 - num2;
            } else if (e.getSource() == multButton) {
                resultado = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                resultado = num1 / num2;
            }

            resultadoField.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}

