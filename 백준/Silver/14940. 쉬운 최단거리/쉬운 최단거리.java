import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, sr, sc;

  static int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};

  static long[][] board, distance;
  static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new long[N][M];
    distance = new long[N][M];
    visited = new boolean[N][M];

    for (int r = 0; r < N; r++) {
      Arrays.fill(distance[r], -1);
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
        if (board[r][c] == 2) {
          sr = r;
          sc = c;
        } else if (board[r][c] == 0) {
          distance[r][c] = 0;
        }
      }
    }

    bfs(sr, sc);

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        sb.append(distance[r][c]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

  private static void bfs(int r, int c) {
    int nr, nc;
    Queue<int[]> q = new LinkedList<>();

    visited[r][c] = true;
    q.add(new int[] {r, c});
    distance[r][c] = 0;

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      q.poll();

      for (int d = 0; d < 4; d++) {
        nr = r + dr[d];
        nc = c + dc[d];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
          continue;

        if (board[nr][nc] == 0) {
          distance[nr][nc] = 0;
          continue;
        } else {
          distance[nr][nc] = distance[r][c] + 1;
          q.add(new int[] {nr, nc});
          visited[nr][nc] = true;
        }

      }

    }

  }

}