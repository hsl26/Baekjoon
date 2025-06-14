import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;



    N = Integer.parseInt(br.readLine());

    dp = new int[N + 1];

    dp[1] = 1;
    if (N >= 2)
      dp[2] = dp[1] + 2;

    for (int i = 3; i <= N; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
    }

    System.out.println(dp[N]);

  }
}