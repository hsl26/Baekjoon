import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int M, N;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] board, score, visited;

  static Queue<int[]> tomato = new LinkedList<>();

  public static void main(String[] args) throws Exception {

    init();


    bfs();

    int answer = score[0][0];

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (board[r][c] == 0)
          answer = Math.max(answer, score[r][c]);
      }
    }

    if (answer == 1000 * 1000)
      answer = -1;

    System.out.println(answer);

  }

  private static void bfs() {
    while (!tomato.isEmpty()) {
      int[] coor = tomato.remove();

      for (int d = 0; d < 4; d++) {
        int nr = coor[0] + dr[d];
        int nc = coor[1] + dc[d];

        if (canGo(nr, nc)) {
          tomato.add(new int[] {nr, nc});
          visited[nr][nc] = 1;
          score[nr][nc] = Math.min(score[nr][nc], score[coor[0]][coor[1]] + 1);
        }
      }
    }
  }


  private static boolean canGo(int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= M)
      return false;

    if (visited[r][c] == 1 || board[r][c] != 0)
      return false;

    return true;
  }


  private static void init() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    score = new int[N][M];
    visited = new int[N][M];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());

      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
        if (board[r][c] == 0)
          score[r][c] = 1000 * 1000;
        else if (board[r][c] == 1) {
          tomato.add(new int[] {r, c});
          visited[r][c] = 1;
          score[r][c] = 0;
        } else
          score[r][c] = -1;
      }
    }
  }
}