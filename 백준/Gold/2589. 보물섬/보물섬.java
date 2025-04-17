import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, ans = 0;
  static char[][] board;
  static int[][] visited;
  static int[] first, second;

  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new char[N][M];

    for (int r = 0; r < N; r++) {
      String arr = br.readLine();
      for (int c = 0; c < M; c++) {
        board[r][c] = arr.charAt(c);
      }
    }

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (board[r][c] == 'L') {
          visited = new int[N][M];
          bfs(r, c);
        }
      }
    }
    System.out.println(ans);
  }

  private static void bfs(int r, int c) {
    int nr, nc, sr = r, sc = c;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {r, c});

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      q.remove();

      ans = Math.max(ans, visited[r][c]);

      for (int d = 0; d < 4; d++) {
        nr = r + drs[d];
        nc = c + dcs[d];

        if (canGo(nr, nc) && !(nr == sr && nc == sc)
            && (visited[nr][nc] == 0 || visited[nr][nc] > visited[r][c] + 1)) {
          visited[nr][nc] = visited[r][c] + 1;
          q.add(new int[] {nr, nc});
        }
      }
    }

  }

  private static boolean canGo(int r, int c) {

    if (r < 0 || r >= N || c < 0 || c >= M) {
      return false;
    }

    if (board[r][c] == 'W')
      return false;

    return true;
  }

}