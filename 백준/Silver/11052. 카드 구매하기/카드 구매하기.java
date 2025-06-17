import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[] board, dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    board = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    dp = new int[N + 1];

    dp[1] = board[1];
    if (N >= 2)
      dp[2] = Math.max(dp[1] * 2, board[2]);
    if (N >= 3)
      dp[3] = Math.max(dp[1] + dp[2], board[3]);

    for (int i = 4; i <= N; i++) {
      int res = 0;
      for (int j = 1; j <= i / 2; j++) {
        res = Math.max(res, dp[j] + dp[i - j]);
      }

      dp[i] = Math.max(board[i], res);
    }

    System.out.println(dp[N]);

  }

}