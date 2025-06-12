import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int T, N;

  static long[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      N = Integer.parseInt(br.readLine());

      dp = new long[N + 1];

      dp[1] = 1;
      if (N >= 2)
        dp[2] = 1;
      if (N >= 3)
        dp[3] = 1;
      if (N >= 4)
        dp[4] = 2;
      if (N >= 5)
        dp[5] = 2;

      for (int i = 6; i <= N; i++) {
        dp[i] = dp[i - 1] + dp[i - 5];
      }

      System.out.println(dp[N]);

    }
  }

}