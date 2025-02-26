import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int l, sr, sc, er, ec;

  static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
  static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

  static int[][] board;
  static int[][] visited;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      l = Integer.parseInt(br.readLine());

      board = new int[l][l];

      for (int i = 0; i < l; i++) {
        Arrays.fill(board[i], Integer.MAX_VALUE);
      }

      st = new StringTokenizer(br.readLine());
      sr = Integer.parseInt(st.nextToken());
      sc = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      er = Integer.parseInt(st.nextToken());
      ec = Integer.parseInt(st.nextToken());

      bfs();

      System.out.println(board[er][ec]);

    }

  }

  private static void bfs() {

    Queue<int[]> q = new LinkedList<>();
    visited = new int[l][l];

    q.add(new int[] {sr, sc});
    visited[sr][sc] = 1;
    board[sr][sc] = 0;

    while (!q.isEmpty()) {
      int r = q.peek()[0];
      int c = q.peek()[1];
      q.remove();

      for (int d = 0; d < 8; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (canGo(nr, nc)) {
          q.add(new int[] {nr, nc});
          visited[nr][nc] = 1;
          board[nr][nc] = Math.min(board[nr][nc], board[r][c] + 1);
        }
      }
    }

  }

  private static boolean canGo(int r, int c) {

    if (r < 0 || r >= l || c < 0 || c >= l)
      return false;

    if (visited[r][c] == 1)
      return false;

    return true;
  }

}