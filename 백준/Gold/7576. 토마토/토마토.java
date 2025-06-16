import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int M, N, tobe;

  static int[][] board;

  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};

  static Queue<int[]> tomato = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    tobe = 0;

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());

        if (board[r][c] == 1) {
          tomato.add(new int[] {r, c});
        } else if (board[r][c] == 0) {
          tobe++;
        }
      }
    }

    if (tobe == 0) {
      System.out.println(0);
      return;
    }

    int cnt = 0;
    while (tobe > 0 && !tomato.isEmpty()) {

      bfs();
      cnt++;
    }

    if (tobe > 0) {
      System.out.println(-1);
    } else {
      System.out.println(cnt);
    }
  }

  private static void bfs() {

    Queue<int[]> newTomato = new LinkedList<>();

    while (!tomato.isEmpty()) {
      int[] arr = tomato.poll();

      for (int d = 0; d < 4; d++) {
        int nr = arr[0] + drs[d];
        int nc = arr[1] + dcs[d];

        if (canGo(nr, nc)) {
          newTomato.add(new int[] {nr, nc});
          board[nr][nc] = 1;
          tobe--;
        }
      }
    }

    while (!newTomato.isEmpty()) {
      int[] arr = newTomato.poll();
      tomato.add(arr);
    }

  }

  private static boolean canGo(int r, int c) {

    if (r < 0 || r >= N || c < 0 || c >= M)
      return false;

    if (board[r][c] != 0)
      return false;

    return true;
  }
}