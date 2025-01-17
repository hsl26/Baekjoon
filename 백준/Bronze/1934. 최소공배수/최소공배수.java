import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int A, B;
			A = sc.nextInt();
			B = sc.nextInt();
			
			System.out.println(A*B/GCD(A, B));
			
		}
	}
	
	public static int GCD(int a, int b) {
		while (b > 0) {
			int tmp;
			tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
}
