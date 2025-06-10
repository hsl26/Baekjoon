import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int T, N;

  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      N = Integer.parseInt(br.readLine());

      dp = new int[N + 1][2];

      dp[0][0] = 1;
      if (N >= 1)
        dp[1][1] = 1;

      for (int i = 2; i <= N; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
      }


      System.out.println(dp[N][0] + " " + dp[N][1]);
    }

  }

}

