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

    for (int i = 1; i <= N; i++) {

      if (i - 5 >= 0) {
        dp[i] = Math.min(dp[i - 3] + 1, Math.min(dp[i - 5] + 1, dp[i]));
      } else if (i - 3 >= 0) {
        dp[i] = Math.min(dp[i - 3] + 1, dp[i]);
      }
    }

    if (dp[N] == N) {
      dp[N] = -1;
    }

    System.out.println(dp[N]);

  }

}