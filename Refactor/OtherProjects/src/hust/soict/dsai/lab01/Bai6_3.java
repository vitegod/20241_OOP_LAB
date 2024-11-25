package hust.soict.dsai.lab01;
import java.util.*;
public class Bai6_3 {
	public static void main(String[] arg ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your number: ");
		int n = sc.nextInt();
		int h = n - 1;
		int m = 1;
		for (int i = 0; i < n; i++) {
			for (int k = 1; k <= h; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= m; j++) {
				System.out.print("*");
			}
			System.out.println();
			m += 2;
			h--;
		}
		System.exit(0);
	}
}
