import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  static final int INF = 100 * 100 * 9 + 1;
  static int N;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] board, DP;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());

      board = new int[N][N];
      DP = new int[N][N];

      for (int r = 0; r < N; r++) {
        String[] arr = br.readLine().split("");

        for (int c = 0; c < N; c++)
          board[r][c] = Integer.parseInt(arr[c]);

      }

      for (int r = 0; r < N; r++)
        Arrays.fill(DP[r], INF);

      DP[0][0] = 0;

      bfs();

      sb.append(DP[N - 1][N - 1]).append("\n");

    }
    System.out.println(sb);
  }

  private static void bfs() {

    Queue<int[]> q = new LinkedList<>();

    q.add(new int[] {0, 0});

    while (!q.isEmpty()) {
      int[] arr = q.poll();
      int r = arr[0], c = arr[1];

      for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= N || nc < 0 || nc >= N)
          continue;


        if (DP[r][c] + board[nr][nc] >= DP[nr][nc])
          continue;

        DP[nr][nc] = DP[r][c] + board[nr][nc];
        q.add(new int[] {nr, nc});
      }

    }

  }
}