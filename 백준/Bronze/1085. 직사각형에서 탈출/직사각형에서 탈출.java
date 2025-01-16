import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x, y, w, h;

		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		
		int ans = 1001;
		
		if (ans > x) {
			ans = x;
		}
		if (ans > y) {
			ans = y;
		}
		if (ans > Math.abs(x-w)) {
			ans = Math.abs(x-w);
		}
		if (ans > Math.abs(y-h)) {
			ans = Math.abs(y-h);
		}
		
		System.out.print(ans);
	}
}
