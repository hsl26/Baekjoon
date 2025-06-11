import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[][] dp, cost;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    cost = new int[N + 1][4];
    dp = new int[N + 1][4];

    for (int r = 1; r <= N; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int c = 1; c <= 3; c++) {
        cost[r][c] = Integer.parseInt(st.nextToken());
        dp[r][c] = 1000 * 3 * N;
      }
    }

    for (int i = 1; i <= 3; i++) {
      dp[1][i] = cost[1][i];
    }

    for (int r = 2; r <= N; r++) {
      for (int c = 1; c <= 3; c++) {
        for (int i = 1; i <= 3; i++) {

          if (c == i)
            continue;

          dp[r][c] = Math.min(dp[r - 1][i] + cost[r][c], dp[r][c]);
        }
      }
    }

    int ans = 1000 * 3 * N;
    for (int i = 1; i <= 3; i++) {
      ans = Math.min(dp[N][i], ans);
    }

    System.out.println(ans);
  }

}