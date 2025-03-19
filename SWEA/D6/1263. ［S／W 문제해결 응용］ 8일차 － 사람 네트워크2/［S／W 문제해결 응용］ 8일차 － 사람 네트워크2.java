import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N;
  static int[][] board;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());

      board = new int[N][N];

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      for (int k = 0; k < N; k++) {
        for (int r = 0; r < N; r++) {
          for (int c = 0; c < N; c++) {
            if (r == c)
              continue;

            if (board[r][k] != 0 && board[k][c] != 0) {
              if (board[r][c] == 0)
                board[r][c] = board[r][k] + board[k][c];

              else
                board[r][c] = Math.min(board[r][c], board[r][k] + board[k][c]);

            }
          }
        }
      }

      int answer = Integer.MAX_VALUE;

      for (int r = 0; r < N; r++) {
        int sum = 0;
        for (int c = 0; c < N; c++) {
          sum += board[r][c];
        }

        answer = Math.min(answer, sum);
      }

      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }
}