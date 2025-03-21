import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, answer;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] board, wall;

  static boolean[][] visited;

  static List<int[]> candidate;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    wall = new int[3][2];
    candidate = new ArrayList<>();

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());

        if (board[r][c] == 0) {
          candidate.add(new int[] {r, c});
        }
      }
    }

    answer = 0;

    comb(0, 0);

    System.out.println(answer);

  }

  private static void comb(int cur, int d) {

    if (d == 3) {

      visited = new boolean[N][M];

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < M; c++) {
          if (board[r][c] == 2 && !visited[r][c]) {
            bfs(r, c);
          }
        }
      }


      int cnt = 0;
      for (int r = 0; r < N; r++) {
        for (int c = 0; c < M; c++) {
          if (board[r][c] == 0 && !visited[r][c])
            cnt++;
        }
      }

      answer = Math.max(answer, cnt);

      return;
    }

    for (int i = cur; i < candidate.size(); i++) {

      board[candidate.get(i)[0]][candidate.get(i)[1]] = 1;
      comb(i + 1, d + 1);
      board[candidate.get(i)[0]][candidate.get(i)[1]] = 0;

    }

  }

  private static void bfs(int r, int c) {
    int nr, nc;
    Queue<int[]> q = new LinkedList<>();
    visited[r][c] = true;
    q.add(new int[] {r, c});

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      q.remove();

      for (int d = 0; d < 4; d++) {
        nr = r + dr[d];
        nc = c + dc[d];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M)
          continue;

        if (visited[nr][nc])
          continue;

        if (board[nr][nc] != 0)
          continue;

        visited[nr][nc] = true;
        q.add(new int[] {nr, nc});
      }
    }

  }
}