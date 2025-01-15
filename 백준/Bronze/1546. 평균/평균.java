
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		int maxScore = nums[N-1];
		
		double sum = 0;
		
		for(int i=0; i<N; i++) {
			sum += nums[i]*100.0/maxScore;
		}
		
		System.out.print(sum / N);
	}

}
