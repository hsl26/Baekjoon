import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  static int[][] board;
  static int[][] visited;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int t = 1; t <= 10; t++) {

      sb.append("#").append(t).append(" ");

      br.readLine();

      board = new int[16][16];
      visited = new int[16][16];

      for (int r = 0; r < 16; r++) {
        String[] arr = br.readLine().split("");
        for (int c = 0; c < 16; c++) {
          board[r][c] = Integer.parseInt(arr[c]);
        }
      }

      int answer = 0;

      for (int r = 0; r < 16; r++) {
        for (int c = 0; c < 16; c++) {
          if (board[r][c] == 2) {
            if (bfs(r, c)) {
              answer = 1;
            }
          }
        }
      }

      sb.append(answer).append("\n");

    }
    System.out.println(sb);
  }

  private static boolean bfs(int r, int c) {

    Queue<int[]> q = new LinkedList<>();

    q.add(new int[] {r, c});
    visited[r][c] = 1;

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      q.remove();

      if (board[r][c] == 3) {
        return true;
      }

      for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (can_go(nr, nc)) {
          q.add(new int[] {nr, nc});
          visited[nr][nc] = 1;
        }
      }
    }

    return false;

  }

  private static boolean can_go(int nr, int nc) {
    if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16)
      return false;

    if (board[nr][nc] == 1 || visited[nr][nc] == 1)
      return false;

    return true;
  }
}