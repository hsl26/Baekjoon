import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int M, N, H;
  static int h, r, c, nh, nr, nc;

  static int[] dh = {-1, 0, 0, 0, 0, 1}, dr = {0, 0, 0, 1, -1, 0}, dc = {0, 1, -1, 0, 0, 0};

  static int[][][] box;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    box = new int[H][N][M];

    Queue<int[]> q = new LinkedList<>();
    int tomato = 0;

    for (int h = 0; h < H; h++) {
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < M; c++) {
          box[h][r][c] = Integer.parseInt(st.nextToken());

          if (box[h][r][c] == 1)
            q.add(new int[] {h, r, c});
          else if (box[h][r][c] == 0)
            tomato++;
        }
      }
    }

    if (tomato == 0)
      System.out.println(0);
    else {
      while (!q.isEmpty()) {
        h = q.peek()[0];
        r = q.peek()[1];
        c = q.peek()[2];
        q.poll();

        for (int d = 0; d < 6; d++) {
          nh = h + dh[d];
          nr = r + dr[d];
          nc = c + dc[d];

          if (canGo(nh, nr, nc)) {
            q.add(new int[] {nh, nr, nc});
            box[nh][nr][nc] = box[h][r][c] + 1;
          }
        }
      }

      int max = 0;
      tomato = 0;
      for (int h = 0; h < H; h++) {
        for (int r = 0; r < N; r++) {
          for (int c = 0; c < M; c++) {
            max = Math.max(max, box[h][r][c]);
            if (box[h][r][c] == 0) {
              tomato = 1;
              break;
            }
          }
        }
      }

      if (tomato > 0)
        System.out.println(-1);
      else
        System.out.println(max - 1);

    }

  }

  private static boolean canGo(int h, int r, int c) {
    if (h < 0 || h >= H || r < 0 || c < 0 || r >= N || c >= M)
      return false;

    if (box[h][r][c] != 0)
      return false;

    return true;
  }
}