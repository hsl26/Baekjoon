import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    long[][] dp = new long[n + 1][10];

    Arrays.fill(dp[1], 1);
    dp[1][0] = 0;

    for (int i = 2; i <= n; i++) {
      dp[i][0] = dp[i - 1][1];
      for (int j = 1; j < 9; j++) {
        dp[i][j] = (dp[i - 1][(j + 9) % 10] + dp[i - 1][(j + 1) % 10]) % 1000000000;
      }
      dp[i][9] = dp[i - 1][8];
    }

    long answer = 0;
    for (int i = 0; i < 10; i++) {
      answer += dp[n][i];
      answer %= 1000000000;
    }

    System.out.println(answer);
  }
}