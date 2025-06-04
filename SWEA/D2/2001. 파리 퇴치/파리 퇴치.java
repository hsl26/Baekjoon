import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int T, N, M, max;
  static int[][] board;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      board = new int[N][N];

      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      max = 0;

      for (int r = 0; r <= N - M; r++) {
        for (int c = 0; c <= N - M; c++) {
          max = Math.max(max, cal(r, c));
        }
      }

      sb.append(max).append("\n");

    }

    System.out.println(sb);
  }

  private static int cal(int a, int b) {

    int sum = 0;

    for (int r = a; r < a + M; r++) {
      for (int c = b; c < b + M; c++) {
        sum += board[r][c];
      }
    }

    return sum;
  }


}