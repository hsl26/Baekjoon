import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m, a, b, c;

  static int[][] board;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    board = new int[n][n];


    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        board[r][c] = 100000 * n * n + 1;
      }
      board[r][r] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken()) - 1;
      b = Integer.parseInt(st.nextToken()) - 1;
      c = Integer.parseInt(st.nextToken());

      board[a][b] = Math.min(c, board[a][b]);
    }


    for (int k = 0; k < n; k++) {
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {

          int nc = board[r][k] + board[k][c];

          board[r][c] = Math.min(board[r][c], nc);
        }
      }
    }

    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] == 100000 * n * n + 1)
          board[r][c] = 0;
        sb.append(board[r][c]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }
}
