import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

  static int T, N;

  static int[] drs = {0, 1, 0, -1}, dcs = {1, 0, -1, 0};

  static int[][] board, visited;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append('#').append(t).append('\n');


      N = Integer.parseInt(br.readLine());

      board = new int[N][N];

      bfs();

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          sb.append(board[r][c]).append(' ');
        }
        sb.append('\n');
      }
    }

    System.out.println(sb);
  }

  private static void bfs() {

    int r = 0, c = 0, d = 0, nr, nc;

    board[r][c] = 1;
    int n = 1;

    while (n < N * N) {
      nr = r + drs[d];
      nc = c + dcs[d];
      if (canGo(nr, nc)) {

        board[nr][nc] = ++n;
        r = nr;
        c = nc;

      } else {
        d = (d + 1) % 4;
      }
    }

  }

  private static boolean canGo(int r, int c) {

    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;

    if (board[r][c] != 0)
      return false;

    return true;
  }

}