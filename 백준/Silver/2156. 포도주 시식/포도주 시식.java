import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static long[] dp;
  static int[] wine;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    dp = new long[N + 1];
    wine = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      wine[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = wine[1];
    if (N >= 2)
      dp[2] = dp[1] + wine[2];

    for (int i = 3; i <= N; i++) {
      dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
    }

    long ans = 0;
    for (int i = 1; i <= N; i++) {
      ans = Math.max(ans, dp[i]);
    }

    System.out.println(ans);

  }
}