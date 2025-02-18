import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int N;
	private static int M;
	private static int[] numbers; // 하나의 경우를 담는 배열

	private static void combination(int cnt, int start) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		// 유도부분
		for (int i = start; i <= N; i++) {

			numbers[cnt] = i; 
			combination(cnt + 1, i + 1); 
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];
		combination(0, 1);
	}

}