import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, L, R;
  static int[][] board, visited;

  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    board = new int[N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    while (true) {

      visited = new int[N][N];
      boolean move = false;

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (visited[r][c] == 0) {
            bfs(r, c, (r + 1) * 10 + (c + 1));
          }
        }
      }

      for (int r = 0; r < N && !move; r++) {
        for (int c = 0; c < N; c++) {
          if (visited[r][c] == (r + 1) * 10 + (c + 1) || visited[r][c] == 0)
            continue;

          move = true;
          break;

        }
      }

      if (!move)
        break;
      else
        cnt++;
    }

    System.out.println(cnt);

  }


  private static void bfs(int sr, int sc, int n) {
    int r = sr, c = sc, nr, nc, sum = 0;
    Queue<int[]> q = new LinkedList<>(), coor = new LinkedList<>();
    visited[r][c] = n;
    int[] arr = {r, c};
    q.add(arr);

    while (!q.isEmpty()) {

      arr = q.poll();
      r = arr[0];
      c = arr[1];

      coor.add(arr);
      sum += board[r][c];

      for (int d = 0; d < 4; d++) {
        nr = r + drs[d];
        nc = c + dcs[d];

        if (inRange(nr, nc)) {
          int del = Math.abs(board[r][c] - board[nr][nc]);
          if (del >= L && del <= R) {
            visited[nr][nc] = n;
            q.add(new int[] {nr, nc});
          }
        }
      }
    }

    int cnt = coor.size();
    int res = sum / cnt;

    if (cnt == 1)
      return;

    while (!coor.isEmpty()) {
      arr = coor.poll();
      board[arr[0]][arr[1]] = res;
    }


  }

  private static boolean inRange(int r, int c) {

    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;

    if (visited[r][c] > 0)
      return false;

    return true;
  }
}
