import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static boolean find = false;
  static int[][] board;
  static LinkedList<int[]> zero = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    board = new int[9][9];

    for (int r = 0; r < 9; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < 9; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
        if (board[r][c] == 0) {
          zero.add(new int[] {r, c});
        }
      }
    }

    dfs(0);

    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        System.out.print(board[r][c] + " ");
      }
      System.out.println();
    }
  }

  private static void dfs(int d) {
    if (d == zero.size()) {
      find = true;
      return;
    }

    int r = zero.get(d)[0], c = zero.get(d)[1];

    for (int n = 1; n <= 9; n++) {
      // 가로 되는지 && 세로 되는지 && 사각형 되는지
      if (row(r, c, n) && col(r, c, n) && rec(r, c, n)) {
        board[r][c] = n;
        dfs(d + 1);

        if (find)
          return;

        board[r][c] = 0;

      }
    }

  }

  private static boolean rec(int r, int c, int n) {

    for (int row = r / 3 * 3; row < (r / 3 + 1) * 3; row++) {
      for (int col = c / 3 * 3; col < (c / 3 + 1) * 3; col++) {
        if (!(r == row && c == col) && board[row][col] == n)
          return false;
      }
    }

    return true;
  }

  private static boolean col(int r, int c, int n) {
    for (int i = 0; i < 9; i++) {
      if (i != r && board[i][c] == n)
        return false;
    }

    return true;
  }

  private static boolean row(int r, int c, int n) {

    for (int i = 0; i < 9; i++) {
      if (i != c && board[r][i] == n)
        return false;
    }

    return true;
  }
}
