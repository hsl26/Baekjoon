import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K;
  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};
  static int[][] map;
  static int[][][] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    distance = new int[N][M][K + 1];

    for (int r = 0; r < N; r++) {
      String[] arr = br.readLine().split("");
      for (int c = 0; c < M; c++) {
        map[r][c] = Integer.parseInt(arr[c]);
        Arrays.fill(distance[r][c], N * M + 1);
      }
    }

    bfs();

    int ans = N * M + 1;
    for (int i = 0; i <= K; i++) {
      ans = Math.min(ans, distance[0][0][i]);
    }

    if (ans == N * M + 1)
      ans = -1;

    System.out.println(ans);
  }

  private static void bfs() {
    int r, c, nr, nc;
    int[] arr = new int[2];

    Queue<int[]> q = new LinkedList<>();
    distance[N - 1][M - 1][0] = 1;
    q.add(new int[] {N - 1, M - 1});

    while (!q.isEmpty()) {
      arr = q.remove();
      r = arr[0];
      c = arr[1];

      for (int d = 0; d < 4; d++) {
        nr = r + drs[d];
        nc = c + dcs[d];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M)
          continue;

        if (map[nr][nc] == 1) {
          boolean add = false;
          for (int i = 1; i <= K; i++) {
            if (distance[r][c][i - 1] + 1 < distance[nr][nc][i]) {
              distance[nr][nc][i] = distance[r][c][i - 1] + 1;
              add = true;
            }
          }

          if (add)
            q.add(new int[] {nr, nc});

        } else {
          boolean add = false;

          for (int i = 0; i <= K; i++) {
            if (distance[r][c][i] + 1 < distance[nr][nc][i]) {
              distance[nr][nc][i] = distance[r][c][i] + 1;
              add = true;
            }
          }

          if (add)
            q.add(new int[] {nr, nc});

        }

      }
    }
  }

}