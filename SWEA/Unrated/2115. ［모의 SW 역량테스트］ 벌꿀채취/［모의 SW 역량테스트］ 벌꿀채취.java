import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

  static int N, M, C, ans1, ans2, total;

  static int[][] board;

  static ArrayList<int[]> first = new ArrayList<>();
  static ArrayList<int[]> second = new ArrayList<>();

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");
      total = 0;

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      board = new int[N][N];

      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      for (int r = 0; r < N; r++) {
        for (int c = 0; c <= N - M; c++) {

          for (int i = 0; i < M; i++)
            first.add(new int[] {r, c + i});

          for (int r2 = 0; r2 < N; r2++) {
            for (int c2 = 0; c2 <= N - M; c2++) {
              if (r == r2 && !(c2 >= c + M || c >= c2 + M))
                continue;

              for (int i = 0; i < M; i++)
                second.add(new int[] {r2, c2 + i});

              ans1 = 0;
              ans2 = 0;
              bt1(0, 0, 0, new int[M]);
              bt2(0, 0, 0, new int[M]);
              total = Math.max(total, ans1 + ans2);

              second.clear();
            }
          }
          first.clear();
        }
      }

      sb.append(total).append("\n");

    }
    System.out.println(sb);

  }

  private static void bt1(int d, int sum, int sum2, int[] v) {
    ans1 = Math.max(sum2, ans1);

    if (d == M) {
      return;
    }

    for (int i = 0; i < first.size(); i++) {
      int[] coor = first.get(i);

      if (sum + board[coor[0]][coor[1]] <= C && v[i] == 0) {
        v[i] = 1;
        bt1(d + 1, sum + board[coor[0]][coor[1]],
            sum2 + board[coor[0]][coor[1]] * board[coor[0]][coor[1]], v);
        v[i] = 0;

      }
    }
  }

  private static void bt2(int d, int sum, int sum2, int[] v) {
    ans2 = Math.max(sum2, ans2);

    if (d == M) {
      return;
    }

    for (int i = 0; i < second.size(); i++) {
      int[] coor = second.get(i);

      if (sum + board[coor[0]][coor[1]] <= C && v[i] == 0) {
        v[i] = 1;
        bt2(d + 1, sum + board[coor[0]][coor[1]],
            sum2 + board[coor[0]][coor[1]] * board[coor[0]][coor[1]], v);
        v[i] = 0;

      }
    }
  }
}