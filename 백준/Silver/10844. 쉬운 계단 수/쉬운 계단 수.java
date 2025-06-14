import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static long[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    dp = new long[N + 1][10];

    for (int i = 1; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int r = 2; r <= N; r++) {
      for (int i = 0; i <= 9; i++) {
        if (i != 9 && i != 0)
          dp[r][i] = (dp[r - 1][i - 1] + dp[r - 1][i + 1]) % 1000000000;
        else if (i == 9)
          dp[r][i] = dp[r - 1][i - 1];
        else
          dp[r][i] = dp[r - 1][i + 1];
      }
    }

    long ans = 0;
    for (int i = 0; i <= 9; i++) {
      ans += dp[N][i];
    }

    System.out.println(ans %= 1000000000);

  }
}