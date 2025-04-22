import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int R, C, ans = 0;

  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};

  static boolean[] alpha = new boolean[26];

  static char[][] board;

  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    board = new char[R][C];
    visited = new boolean[R][C];

    for (int r = 0; r < R; r++) {
      String str = br.readLine();
      for (int c = 0; c < C; c++) {
        board[r][c] = str.charAt(c);
      }
    }

    visited[0][0] = true;
    alpha[board[0][0] - 'A'] = true;
    dfs(0, 0, 1);

    System.out.println(ans);
  }

  private static void dfs(int r, int c, int cnt) {

    if (cnt > ans)
      ans = cnt;


    for (int d = 0; d < 4; d++) {
      int nr = r + drs[d];
      int nc = c + dcs[d];

      if (canGo(nr, nc)) {
        visited[nr][nc] = true;
        alpha[board[nr][nc] - 'A'] = true;
        dfs(nr, nc, cnt + 1);
        visited[nr][nc] = false;
        alpha[board[nr][nc] - 'A'] = false;
      }

    }

  }

  private static boolean canGo(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C)
      return false;

    if (alpha[board[r][c] - 'A'] || visited[r][c])
      return false;

    return true;
  }
}