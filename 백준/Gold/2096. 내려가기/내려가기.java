import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[][] board;
  static int[][][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    board = new int[N][3];
    dp = new int[2][3][2];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < 3; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    for (int c = 0; c < 3; c++) {
      dp[0][c][0] = board[0][c];
      dp[0][c][1] = board[0][c];
      dp[1][c][1] = 900001;
    }


    for (int r = 0; r < N - 1; r++) {
      int next = (r + 1) % 2, cur = r % 2;
      for (int c = 0; c < 3; c++) {
        if (c != 0) {
          dp[next][2][0] = Math.max(dp[r % 2][c][0] + board[r + 1][2], dp[next][2][0]);
          dp[next][2][1] = Math.min(dp[r % 2][c][1] + board[r + 1][2], dp[next][2][1]);
        }

        if (c != 2) {
          dp[next][0][0] = Math.max(dp[r % 2][c][0] + board[r + 1][0], dp[next][0][0]);
          dp[next][0][1] = Math.min(dp[r % 2][c][1] + board[r + 1][0], dp[next][0][1]);
        }

        dp[next][1][0] = Math.max(dp[r % 2][c][0] + board[r + 1][1], dp[next][1][0]);
        dp[next][1][1] = Math.min(dp[r % 2][c][1] + board[r + 1][1], dp[next][1][1]);

      }

      for (int c = 0; c < 3; c++) {
        dp[cur][c][1] = 900001;
      }
    }

    int max = dp[(N - 1) % 2][0][0];
    int min = dp[(N - 1) % 2][0][1];

    for (int c = 1; c < 3; c++) {
      max = Math.max(max, dp[(N - 1) % 2][c][0]);
      min = Math.min(min, dp[(N - 1) % 2][c][1]);
    }

    System.out.println(max + " " + min);

  }

}