import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int tmp = 10, ans = 0;

		while (tmp >= 0) {
			if (N >= Math.pow(10, tmp)-1) {
				ans += (tmp+1) * (int)(Math.min(Math.pow(10, tmp+1)-1, N) - (Math.pow(10, tmp) - 1));
			}
			tmp--;
		}

		System.out.println(ans);

	}
}
