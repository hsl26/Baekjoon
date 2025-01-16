import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, max = 0, idx = -1;
		
		for (int i = 0; i < 9; i++) {
			a = sc.nextInt();
			if (max < a) {
				max = a;
				idx = i;
			}
		}

		System.out.println(max);
		System.out.println(idx+1);
		
	}
}
