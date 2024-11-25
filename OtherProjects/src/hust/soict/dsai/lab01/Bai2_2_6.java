package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Bai2_2_6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Solve a linear equation (ax + b = 0)");
            System.out.println("2. Solve a system of linear equations (ax + by = c, dx + ey = f)");
            System.out.println("3. Solve a quadratic equation (ax^2 + bx + c = 0)");
            System.out.println("0. Exit");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    solveLinearEquation(input);
                    break;
                case 2:
                    solveLinearSystem(input);
                    break;
                case 3:
                    solveQuadraticEquation(input);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        input.close();
    }

    // Solve linear equation ax + b = 0
    public static void solveLinearEquation(Scanner input) {
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinitely solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    public static void solveLinearEquationAB(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinitely solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    // Solve system of linear equations ax + by = c, dx + ey = f
    public static void solveLinearSystem(Scanner input) {
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();
        System.out.print("Enter d: ");
        double d = input.nextDouble();
        System.out.print("Enter e: ");
        double e = input.nextDouble();
        System.out.print("Enter f: ");
        double f = input.nextDouble();

        double determinant = a * e - b * d;

        if (determinant == 0) {
            if (a * f - c * d == 0 && b * f - c * e == 0) {
                System.out.println("Infinitely solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x = (c * e - b * f) / determinant;
            double y = (a * f - c * d) / determinant;
            System.out.println("The solution is x = " + x + ", y = " + y);
        }
    }

    // Solve quadratic equation ax^2 + bx + c = 0
    public static void solveQuadraticEquation(Scanner input) {
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        if (a == 0) {
            solveLinearEquationAB(b, c);
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The solution is x = " + x);
            } else {
                System.out.println("No real roots.");
            }
        }
    }
}