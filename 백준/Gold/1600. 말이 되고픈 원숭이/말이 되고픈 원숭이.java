import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int K, W, H;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1};
  static int[] hc = {-2, -1, 1, 2, 2, 1, -1, -2};

  static int[][] board;
  static int[][][] DP;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    board = new int[H][W];
    DP = new int[H][W][K + 1];

    for (int r = 0; r < H; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < W; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
        for (int k = 0; k <= K; k++) {
          DP[r][c][k] = Integer.MAX_VALUE;
        }
      }
    }

    DP[0][0][0] = 0;

    System.out.println(bfs());
  }

  private static int bfs() {
    int r, c, hm, nr, nc;

    Queue<int[]> q = new LinkedList<>();

    q.add(new int[] {0, 0, 0});

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      hm = q.peek()[2];
      q.remove();

      if (r == H - 1 && c == W - 1) {
        return DP[r][c][hm];
      }

      for (int d = 0; d < 4; d++) {
        nr = r + dr[d];
        nc = c + dc[d];

        if (nr < 0 || nr >= H || nc < 0 || nc >= W)
          continue;

        if (board[nr][nc] == 1)
          continue;

        if (DP[nr][nc][hm] > DP[r][c][hm] + 1) {
          DP[nr][nc][hm] = DP[r][c][hm] + 1;
          q.add(new int[] {nr, nc, hm});
        }
      }

      if (hm < K)
        for (int h = 0; h < 8; h++) {
          nr = r + hr[h];
          nc = c + hc[h];

          if (nr < 0 || nr >= H || nc < 0 || nc >= W)
            continue;

          if (board[nr][nc] == 1)
            continue;

          if (DP[nr][nc][hm + 1] > DP[r][c][hm] + 1) {
            DP[nr][nc][hm + 1] = DP[r][c][hm] + 1;
            q.add(new int[] {nr, nc, hm + 1});
          }
        }

    }

    return -1;

  }
}