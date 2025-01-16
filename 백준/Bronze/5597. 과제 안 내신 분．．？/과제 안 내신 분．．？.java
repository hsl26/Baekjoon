import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[31];

		for (int i = 0; i < 28; i++) {
			int n = sc.nextInt();
			nums[n-1] = 1;
		}
		
		for (int i = 0; i < 30; i++) {
			if (nums[i] != 1) {
				System.out.println(i+1);
			}
		}
	}
}