import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static char[][] board;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    board = new char[N][N];

    for (int r = 0; r < N; r++) {
      Arrays.fill(board[r], ' ');
    }

    star(N, 0, 0);

    StringBuilder sb = new StringBuilder();

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        sb.append(board[r][c]);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static void star(int n, int r, int c) {

    if (n == 3) {
      board[r][c] = '*';
      board[r][c + 1] = '*';
      board[r][c + 2] = '*';
      board[r + 1][c] = '*';
      board[r + 1][c + 2] = '*';
      board[r + 2][c] = '*';
      board[r + 2][c + 1] = '*';
      board[r + 2][c + 2] = '*';
      return;
    }

    star(n / 3, r, c);
    star(n / 3, r, c + n / 3);
    star(n / 3, r, c + 2 * n / 3);

    star(n / 3, r + n / 3, c);
    star(n / 3, r + n / 3, c + 2 * n / 3);

    star(n / 3, r + 2 * n / 3, c);
    star(n / 3, r + 2 * n / 3, c + n / 3);
    star(n / 3, r + 2 * n / 3, c + 2 * n / 3);

  }

}