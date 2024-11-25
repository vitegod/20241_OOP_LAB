package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Bai6_4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a month (full name, abbreviation, 3 letters, or number): ");
            // Chuan hoa xau
            String monthInput = input.nextLine().trim().toLowerCase();

            System.out.print("Enter a year (non-negative number): ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid year. Please enter a non-negative number.");
                input.next();
                continue;
            }
            int year = input.nextInt();
            input.nextLine();

            if (year < 0) {
                System.out.println("Invalid year. Please enter a non-negative number.");
                continue;
            }

            int month = getMonthNumber(monthInput);
            if (month == -1) {
                System.out.println("Invalid month. Please try again.");
                continue;
            }

            int days = getDaysInMonth(month, year);
            System.out.println("There are " + days + " days in " + monthInput + " " + year + ".");
            break;
        }

        input.close();
    }

    public static int getMonthNumber(String monthInput) {
        switch (monthInput) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 1;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                return 2;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 3;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun":
            case "6":
                return 6;
            case "july":
            case "jul":
            case "7":
                return 7;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 8;
            case "september":
            case "sept.":
            case "sep":
            case "9":
                return 9;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 10;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 11;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 12;
            default:
                return -1;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}
