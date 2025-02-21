import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  static int N, A, B, C, D;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] board, score;

  private static void init(BufferedReader br) throws IOException {
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    C = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      init(br);

      bfs();

      if (score[C][D] == Integer.MAX_VALUE) {
        score[C][D] = -1;
      }
      sb.append(score[C][D]).append("\n");
    }
    System.out.println(sb);
  }

  private static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    score = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(score[i], Integer.MAX_VALUE);
    }

    q.add(new int[] {A, B});
    score[A][B] = 0;

    while (!q.isEmpty()) {
      int r = q.peek()[0];
      int c = q.peek()[1];
      q.remove();

      for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (can_go(nr, nc)) {
          int nextTime = score[r][c] + 1;

          if (board[nr][nc] == 2) {
            int waitTime = (3 - (nextTime % 3)) % 3;
            nextTime += waitTime;
          }

          if (score[nr][nc] > nextTime) {
            score[nr][nc] = nextTime;
            q.add(new int[] {nr, nc});
          }
        }
      }
    }

  }

  private static boolean can_go(int r, int c) {

    if (r < 0 || r >= N || c < 0 || c >= N) {
      return false;
    }

    if (board[r][c] == 1)
      return false;

    return true;
  }

}