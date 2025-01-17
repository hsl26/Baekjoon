import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 2;
		
		while (N > 1) {
			if (N % n == 0) {
				System.out.println(n);
				N /= n;
			} else {
				n += 1;
			}
		}
		
	}

}
