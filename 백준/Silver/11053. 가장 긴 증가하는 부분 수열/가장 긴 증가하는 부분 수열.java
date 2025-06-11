import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[] dp, cost;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    dp = new int[N + 1];
    cost = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int r = 1; r <= N; r++) {
      cost[r] = Integer.parseInt(st.nextToken());

    }

    for (int i = 1; i <= N; i++) {
      dp[i] = 1;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j < i; j++) {
        if (cost[i] > cost[j])
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }

    int ans = 0;

    for (int i = 1; i <= N; i++) {
      ans = Math.max(ans, dp[i]);
    }

    System.out.println(ans);
  }

}