import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static final int MAX = 1000 * 1000 + 1;
  static int N, M;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] board;
  static int[][][] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    dist = new int[N][M][2];

    for (int r = 0; r < N; r++) {
      String[] arr = br.readLine().split("");
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(arr[c]);
        dist[r][c][0] = dist[r][c][1] = MAX;
      }
    }

    int answer = bfs();

    System.out.println(answer);
  }

  private static int bfs() {
    Queue<int[]> q = new LinkedList<>();

    q.add(new int[] {0, 0, 0});
    dist[0][0][0] = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int r = cur[0], c = cur[1], w = cur[2];

      if (r == N - 1 && c == M - 1)
        return dist[r][c][w];

      for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M)
          continue;

        if (board[nr][nc] == 0 && dist[nr][nc][w] > dist[r][c][w] + 1) {
          dist[nr][nc][w] = dist[r][c][w] + 1;
          q.add(new int[] {nr, nc, w});
        }

        if (board[nr][nc] == 1 && w == 0 && dist[nr][nc][1] > dist[r][c][w] + 1) {
          dist[nr][nc][1] = dist[r][c][w] + 1;
          q.add(new int[] {nr, nc, 1});
        }
      }
    }

    return -1;
  }
}