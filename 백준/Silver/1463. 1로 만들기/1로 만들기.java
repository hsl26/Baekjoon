import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int N;

  static int[] dp;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    dp = new int[N + 1];

    Arrays.fill(dp, N);

    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i <= N; i++) {
      if (i % 6 == 0) {
        dp[i] = Math.min(dp[i / 6] + 2,
            Math.min(dp[i / 2] + 1, Math.min(dp[i / 3] + 1, dp[i - 1] + 1)));
      } else if (i % 3 == 0) {
        dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
      } else if (i % 2 == 0) {
        dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
      } else {
        dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
      }
    }

    System.out.println(dp[N]);

  }

}