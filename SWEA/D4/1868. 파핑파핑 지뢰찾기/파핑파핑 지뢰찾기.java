import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  static int N;
  static String[][] board;
  static boolean[][] visited;

  static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
  static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());

      board = new String[N][N];
      visited = new boolean[N][N];

      for (int r = 0; r < N; r++) {
        String[] arr = br.readLine().split("");
        for (int c = 0; c < N; c++) {
          board[r][c] = arr[c];
        }
      }

      int ans = 0;

      // 사방에 지뢰가 없을 때
      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (board[r][c].equals(".")) {
            int cnt = 0;
            for (int d = 0; d < 8; d++) {
              int nr = r + dr[d];
              int nc = c + dc[d];

              if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;

              if (board[nr][nc].equals("*")) {
                cnt++;
              }
            }
            if (cnt == 0) {
              board[r][c] = Integer.toString(cnt);
              bfs(r, c);
              ans++;
            }
          }
        }
      }

      // 남은거
      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (board[r][c].equals(".")) {
            ans++;
          }
        }
      }
	System.out.printf("#%d ", t);
      System.out.println(ans);

    }

  }

  private static void bfs(int r, int c) {
    Queue<int[]> q = new LinkedList<>();

    q.add(new int[] {r, c});
    visited[r][c] = true;

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      q.remove();

      for (int d = 0; d < 8; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (can_go(nr, nc)) {
          q.add(new int[] {nr, nc});
          visited[nr][nc] = true;
        }
      }
    }
  }

  private static boolean can_go(int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;
    if (visited[r][c] == true || !board[r][c].equals("."))
      return false;

    int cnt = 0;
    for (int d = 0; d < 8; d++) {
      int nr = r + dr[d];
      int nc = c + dc[d];

      if (nr < 0 || nr >= N || nc < 0 || nc >= N)
        continue;

      if (board[nr][nc].equals("*")) {
        cnt++;
      }
    }

    board[r][c] = Integer.toString(cnt);

    if (cnt != 0) {
      return false;
    }

    return true;
  }



}
