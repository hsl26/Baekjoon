import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static boolean pipe;
  static int R, C;

  static int[] dr = {-1, 0, 1};
  static int[] dc = {1, 1, 1};

  static String[][] board;

  static int[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    String[] rc = br.readLine().split(" ");

    R = Integer.parseInt(rc[0]);
    C = Integer.parseInt(rc[1]);

    board = new String[R][C];
    visited = new int[R][C];

    for (int r = 0; r < R; r++) {
      String[] s = br.readLine().split("");

      board[r] = s;
    }

    int cnt = 0;
    for (int r = 0; r < R; r++) {
      if (board[r][0].equals("x"))
        continue;

      pipe = false;
      updown(r, 0);

      if (pipe)
        cnt++;
    }

    System.out.println(cnt);
  }

  private static void updown(int r, int c) {

    if (c == C - 1) {
      pipe = true;
      return;
    }

    for (int d = 0; d < 3; d++) {
      int nr = r + dr[d];
      int nc = c + dc[d];

      if (canGo(nr, nc)) {
        visited[nr][nc] = 1;
        updown(nr, nc);

        if (pipe)
          break;

      }

    }

  }

  private static boolean canGo(int r, int c) {

    if (r < 0 || r >= R || c < 0 || c >= C)
      return false;

    if (visited[r][c] == 1 || board[r][c].equals("x"))
      return false;

    return true;
  }
}