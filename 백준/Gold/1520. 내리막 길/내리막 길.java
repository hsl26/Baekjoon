import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int M, N;
  static long cnt = 0;
  static int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};
  static int[][] board, dp;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    dp = new int[N][M];
    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
        dp[r][c] = -1;
      }
    }

    System.out.println(dfs(0, 0));
  }

  private static int dfs(int r, int c) {

    if (r == N - 1 && c == M - 1) {
      return 1;
    }

    if (dp[r][c] != -1)
      return dp[r][c];

    dp[r][c] = 0;

    for (int d = 0; d < 4; d++) {
      int nr = r + dr[d], nc = c + dc[d];

      if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
        if (board[r][c] > board[nr][nc]) {
          dp[r][c] += dfs(nr, nc);
        }
      }
    }

    return dp[r][c];

  }
}