import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N, K, maxH, answer;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      map = new int[N][N];

      maxH = 0;
      answer = -1;
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          map[r][c] = Integer.parseInt(st.nextToken());
          maxH = Math.max(maxH, map[r][c]);
        }
      }

      for (int r = 0; r < N; r++)
        for (int c = 0; c < N; c++)
          if (map[r][c] == maxH) {
            visited = new boolean[N][N];
            visited[r][c] = true;
            dfs(r, c, map[r][c], 1, false);
          }

      sb.append(answer).append("\n");
    }
    System.out.println(sb);

  }

  private static void dfs(int r, int c, int v, int len, boolean useK) {

    if (len > answer) {
      answer = len;
    }

    for (int d = 0; d < 4; d++) {
      int nr = r + dr[d];
      int nc = c + dc[d];

      if (canGo(nr, nc)) {

        if (v > map[nr][nc]) {
          visited[nr][nc] = true;
          dfs(nr, nc, map[nr][nc], len + 1, useK);
          visited[nr][nc] = false;
        }

        if (!useK && v <= map[nr][nc] && map[nr][nc] - K <= v - 1) {
          visited[nr][nc] = true;
          dfs(nr, nc, v - 1, len + 1, true);
          visited[nr][nc] = false;
        }

      }

    }
  }



  private static boolean canGo(int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;

    if (visited[r][c])
      return false;

    return true;
  }

}