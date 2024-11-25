package hust.soict.dsai.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class Bai6_5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] myArray;
        myArray = getArrayFromUser(input);

        Arrays.sort(myArray);

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        double average = (double) sum / myArray.length;

        System.out.println("Sorted array: " + Arrays.toString(myArray));
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);

        input.close();
    }

    public static int[] getArrayFromUser(Scanner input) {
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        return array;
    }
}