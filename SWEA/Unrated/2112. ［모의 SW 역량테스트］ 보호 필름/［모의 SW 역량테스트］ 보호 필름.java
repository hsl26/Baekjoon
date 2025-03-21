import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  static int answer, D, W, K;

  static int[][] board;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());
      D = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      board = new int[D][W];

      for (int r = 0; r < D; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < W; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      if (K == 1 || check())
        sb.append(0).append("\n");
      else {
        answer = Integer.MAX_VALUE;

        dfs(0, 0);

        sb.append(answer).append("\n");
      }
    }
    System.out.println(sb);
  }

  private static void dfs(int idx, int cnt) {

    if (cnt >= answer)
      return;

    if (idx == D) {
      if (check())
        answer = cnt;
      return;
    }

    int[] temp = board[idx].clone();


    dfs(idx + 1, cnt);

    Arrays.fill(board[idx], 0);
    dfs(idx + 1, cnt + 1);

    Arrays.fill(board[idx], 1);
    dfs(idx + 1, cnt + 1);


    board[idx] = temp;

  }

  private static boolean check() {

    int s, cnt;

    for (int c = 0; c < W; c++) {
      cnt = 1;
      s = board[0][c];
      for (int r = 1; r < D; r++) {
        if (cnt >= K)
          break;

        if (s == board[r][c])
          cnt++;
        else {
          s = board[r][c];
          cnt = 1;
        }
      }
      if (cnt < K)
        return false;
    }

    return true;

  }
}