import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};
  static int[][] map;
  static int[][][] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    distance = new int[N][M][2];

    for (int r = 0; r < N; r++) {
      String[] arr = br.readLine().split("");
      for (int c = 0; c < M; c++) {
        map[r][c] = Integer.parseInt(arr[c]);
        Arrays.fill(distance[r][c], 1000001);
      }
    }

    bfs();

    int ans = 0;
    if (distance[0][0][0] == 1000001 && distance[0][0][1] == 1000001)
      ans = -1;
    else
      ans = Math.min(distance[0][0][0], distance[0][0][1]);

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
          if (distance[r][c][0] + 1 < distance[nr][nc][1]) {
            distance[nr][nc][1] = distance[r][c][0] + 1;
            q.add(new int[] {nr, nc});
          }
        } else {
          if (distance[r][c][0] + 1 < distance[nr][nc][0]
              || distance[r][c][1] + 1 < distance[nr][nc][1]) {
            q.add(new int[] {nr, nc});
          }
          if (distance[r][c][0] + 1 < distance[nr][nc][0])
            distance[nr][nc][0] = distance[r][c][0] + 1;
          if (distance[r][c][1] + 1 < distance[nr][nc][1])
            distance[nr][nc][1] = distance[r][c][1] + 1;


        }

      }
    }
  }

}