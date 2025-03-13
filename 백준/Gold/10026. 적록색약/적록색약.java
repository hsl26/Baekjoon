import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] visited;

  static String[][] board;
  static String[][] RGBoard;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    board = new String[N][N];
    RGBoard = new String[N][N];

    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        if (board[i][j].equals("G")) {
          RGBoard[i][j] = "R";
        } else {
          RGBoard[i][j] = board[i][j];
        }
      }
    }

    int cnt = 0;
    visited = new int[N][N];
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (visited[r][c] == 0) {
          bfs(r, c, board);
          cnt++;
        }
      }
    }

    int RGcnt = 0;
    visited = new int[N][N];
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (visited[r][c] == 0) {
          bfs(r, c, RGBoard);
          RGcnt++;
        }
      }
    }

    System.out.println(cnt + " " + RGcnt);

  }

  private static void bfs(int r, int c, String[][] b) {

    Queue<int[]> q = new LinkedList<>();

    visited[r][c] = 1;
    q.add(new int[] {r, c});

    while (!q.isEmpty()) {
      int[] arr = q.poll();

      for (int d = 0; d < 4; d++) {
        int nr = arr[0] + dr[d];
        int nc = arr[1] + dc[d];

        if (canGo(nr, nc, b[r][c], b)) {
          visited[nr][nc] = 1;
          q.add(new int[] {nr, nc});
        }
      }
    }

  }

  private static boolean canGo(int r, int c, String s, String[][] b) {

    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;

    if (visited[r][c] == 1 || !b[r][c].equals(s))
      return false;

    return true;
  }

}