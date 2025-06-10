import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int T, N;

  static int[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      N = Integer.parseInt(br.readLine());

      dp = new int[N + 1];

      Arrays.fill(dp, N);

      dp[0] = 1;
      if (N >= 1)
        dp[1] = 1;
      if (N >= 2)
        dp[2] = 2;

      for (int i = 3; i <= N; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      }

      System.out.println(dp[N]);
    }

  }

}