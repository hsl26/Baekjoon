import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] board;
  static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    visited = new boolean[N][M];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    int max = 0;
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (board[r][c] == 1 && !visited[r][c]) {
          max = Math.max(max, bfs(r, c));
          cnt++;
        }
      }
    }

    System.out.println(cnt + "\n" + max);

  }

  private static int bfs(int r, int c) {
    Queue<int[]> q = new LinkedList<>();
    int size = 0, nr, nc;

    q.add(new int[] {r, c});
    visited[r][c] = true;

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      q.poll();
      size++;

      for (int d = 0; d < 4; d++) {
        nr = r + dr[d];
        nc = c + dc[d];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M)
          continue;

        if (visited[nr][nc] || board[nr][nc] == 0)
          continue;

        q.add(new int[] {nr, nc});
        visited[nr][nc] = true;
      }
    }
    return size;
  }
}
