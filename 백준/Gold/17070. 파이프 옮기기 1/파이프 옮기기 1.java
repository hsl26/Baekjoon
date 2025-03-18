import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int N, cnt = 0;
  static int[][] board;
  static int[][][] visited;

  static Set<String> set = new HashSet<>();

  // 가로 0 / 세로 1 / 대각선 2
  static int[][][] dir = {{{0, 1}, {1, 1}}, {{1, 0}, {1, 1}}, {{0, 1}, {1, 0}, {1, 1}}};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    board = new int[N][N];
    visited = new int[3][N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    visited[0][0][0] = 0;
    visited[0][0][1] = 1;

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        for (int state = 0; state < 3; state++) {
          for (int d = 0; d < dir[state].length; d++) {
            int nr = r + dir[state][d][0];
            int nc = c + dir[state][d][1];

            if (canGo(nr, nc)) {

              int newState = 0;
              if (nr == r)
                newState = 0;
              else if (nc == c)
                newState = 1;
              else
                newState = 2;


              if (newState == 2) {
                if (board[nr - 1][nc] == 1 || board[nr][nc - 1] == 1)
                  continue;
              }

              visited[newState][nr][nc] = visited[newState][nr][nc] + visited[state][r][c];
            }
          }
        }
      }
    }

    System.out
        .println(visited[0][N - 1][N - 1] + visited[1][N - 1][N - 1] + visited[2][N - 1][N - 1]);



  }

  private static boolean canGo(int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;

    if (board[r][c] == 1)
      return false;

    return true;
  }
}