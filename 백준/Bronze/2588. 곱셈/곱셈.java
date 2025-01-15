
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int c, d, e, f;
		c = a * (b%10);
		d = a * (b/10%10);
		e = a * (b/100);
		f = a*b;
		
		System.out.printf("%d\n%d\n%d\n%d",c, d, e, f);
	}
}
