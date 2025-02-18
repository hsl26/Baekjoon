import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int N;
	private static int M;
	private static boolean[] isSelected; // 원소 선택여부 체크배열
	private static int[] numbers; // 하나의 경우를 담는 배열

	private static void permutation(int cnt) {
        if (cnt == M) {  
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {  
            if (isSelected[i]) continue; 
            
            numbers[cnt] = i; 
            isSelected[i] = true;  
            permutation(cnt + 1);  
            isSelected[i] = false; 
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];
		isSelected = new boolean[N + 1]; 

		permutation(0);
	}

}