package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;
public class Bai2_2_5 {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;
        double quot = (num2 != 0) ? (num1 / num2): Double.NaN;
        String strNotification = "Sum: " + sum + "\nDifferent: " + diff + "\nProduct: " + prod + "\nQuoitient: " + quot; 
        JOptionPane.showMessageDialog(null, strNotification, "The result is: ", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
