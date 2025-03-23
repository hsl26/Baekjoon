import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, n;

  static int[][] board;
  static long[][] DP;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    board = new int[N][N];
    DP = new long[N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    DP[0][0] = 1;

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (r == N - 1 && c == N - 1)
          continue;

        n = board[r][c];

        if (r + n < N)
          DP[r + n][c] += DP[r][c];

        if (c + n < N)
          DP[r][c + n] += DP[r][c];
      }
    }

    System.out.println(DP[N - 1][N - 1]);

  }

}