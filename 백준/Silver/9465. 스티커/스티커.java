import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[][] board, dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      N = Integer.parseInt(br.readLine());
      board = new int[2][N + 1];

      for (int r = 0; r < 2; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 1; c <= N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      dp = new int[2][N + 1];

      dp[0][1] = board[0][1];
      dp[1][1] = board[1][1];

      for (int i = 2; i <= N; i++) {
        dp[0][i] = Math.max(dp[1][i - 2], Math.max(dp[0][i - 2], dp[1][i - 1])) + board[0][i];
        dp[1][i] = Math.max(dp[0][i - 2], Math.max(dp[1][i - 2], dp[0][i - 1])) + board[1][i];
      }

      System.out.println(Math.max(dp[0][N], dp[1][N]));

    }

  }

}