package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Bai6_6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matrix1;
        int[][] matrix2;
        matrix1 = getMatrixFromUser(input, "first");
        matrix2 = getMatrixFromUser(input, "second");
        
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrices must have the same size for addition.");
            return;
        }

        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        System.out.println("Resultant Matrix:");
        printMatrix(resultMatrix);

        input.close();
    }

    public static int[][] getMatrixFromUser(Scanner input, String matrixName) {
        System.out.print("Enter the number of rows for the " + matrixName + " matrix: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns for the " + matrixName + " matrix: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the " + matrixName + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}