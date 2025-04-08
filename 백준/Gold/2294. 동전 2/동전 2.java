import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, k;
  static int[] coin;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    dp = new int[k + 1];
    coin = new int[n];

    for (int i = 0; i < n; i++) {
      coin[i] = Integer.parseInt(br.readLine());
      if (coin[i] <= k)
        dp[coin[i]] = 1;
    }

    for (int i = 1; i <= k; i++) {
      if (dp[i] == 0)
        continue;
      for (int j = 0; j < n; j++) {
        if (i + coin[j] <= k) {
          if (dp[i + coin[j]] == 0)
            dp[i + coin[j]] = dp[i] + 1;
          else
            dp[i + coin[j]] = Math.min(dp[i + coin[j]], dp[i] + 1);
        }
      }
    }

    if (dp[k] == 0)
      dp[k] = -1;
    System.out.println(dp[k]);

  }

}