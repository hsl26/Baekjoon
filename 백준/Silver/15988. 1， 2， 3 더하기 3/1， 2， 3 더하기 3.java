import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();

			long[] dp = new long[n + 1];
			dp[1] = 1;
			if (n > 1)
				dp[2] = 2;
			if (n > 2)
				dp[3] = 4;

			for (int i = 4; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
			}

			System.out.println(dp[n]);
		}
	}
}
