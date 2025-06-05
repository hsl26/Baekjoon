import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int T, N, K;

  static int[][] board;

  static int[][] dp;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      board = new int[N + 1][2];

      for (int i = 1; i <= N; i++) {
        st = new StringTokenizer(br.readLine());

        board[i][0] = Integer.parseInt(st.nextToken());
        board[i][1] = Integer.parseInt(st.nextToken());
      }

      dp = new int[N + 1][K + 1];

      for (int i = 1; i <= N; i++) {
        for (int v = 0; v <= K; v++) {
          if (v >= board[i][0]) {
            dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - board[i][0]] + board[i][1]);
          } else {
            dp[i][v] = dp[i - 1][v];
          }
        }
      }

      sb.append(dp[N][K]).append("\n");
    }

    System.out.println(sb);
  }


}