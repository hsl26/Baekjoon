import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static int N, M, answer = Integer.MAX_VALUE;

  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};

  static int[][] board, visited;

  static ArrayList<int[]> cctv = new ArrayList<>();
  static Stack<int[]> cctvStack = new Stack<>();
  static Stack<Integer> cctvCountStack = new Stack<>();

  private static void init() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    visited = new int[N][M];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());

        if (board[r][c] != 6 && board[r][c] > 0)
          cctv.add(new int[] {r, c});
      }
    }
  }

  public static void main(String[] args) throws Exception {

    init();

    bt(0);

    System.out.println(answer);

  }

  private static void bt(int i) {
    if (i >= cctv.size()) {
      int count = 0;
      for (int r = 0; r < N; r++) {
        for (int c = 0; c < M; c++) {
          if (visited[r][c] == 0 && board[r][c] == 0)
            count++;
        }
      }
      answer = Math.min(answer, count);
      return;
    }

    int r = cctv.get(i)[0];
    int c = cctv.get(i)[1];

    for (int[] dir : getDirections(board[r][c])) {
      doCctv(r, c, dir);
      bt(i + 1);
      unDo();
    }
  }

  private static void doCctv(int r, int c, int[] directions) {
    int cnt = 0;

    for (int d : directions) {
      int nr = r, nc = c;
      while (true) {
        nr += dr[d];
        nc += dc[d];

        if (!canGo(nr, nc))
          break;

        if (board[nr][nc] == 0) {
          cnt++;
          visited[nr][nc]++;
          cctvStack.push(new int[] {nr, nc});
        }
      }
    }

    cctvCountStack.push(cnt);
  }

  private static void unDo() {

    int cnt = cctvCountStack.pop();

    while (cnt > 0) {
      int[] pos = cctvStack.pop();
      visited[pos[0]][pos[1]]--;
      cnt--;
    }
  }

  private static int[][] getDirections(int type) {
    switch (type) {
      case 1:
        return new int[][] {{0}, {1}, {2}, {3}};
      case 2:
        return new int[][] {{0, 2}, {1, 3}};
      case 3:
        return new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
      case 4:
        return new int[][] {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
      case 5:
        return new int[][] {{0, 1, 2, 3}};
      default:
        return new int[0][];
    }
  }

  private static boolean canGo(int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= M)
      return false;
    if (board[r][c] == 6)
      return false;
    return true;
  }
}