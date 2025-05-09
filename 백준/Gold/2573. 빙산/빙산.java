import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;

  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};

  static int[][] board, cnt, visited;

  static List<int[]> coor = new LinkedList<>();

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
        if (board[r][c] > 0)
          coor.add(new int[] {r, c});
      }
    }


    int year = 0;
    while (true) {

      cnt = new int[N][M];

      // 각 빙산 위치? 마다 사방 탐색 후 몇 개 줄여야하는지 세기.
      int r, c;
      for (int[] pos : coor) {
        r = pos[0];
        c = pos[1];

        for (int d = 0; d < 4; d++) {
          if (isInRange(r + drs[d], c + dcs[d]) && board[r + drs[d]][c + dcs[d]] == 0)
            cnt[r][c]++;
        }
      }


      // 줄어야하는만큼 줄이기
      List<int[]> newCoor = new LinkedList<>();
      for (int[] pos : coor) {
        r = pos[0];
        c = pos[1];

        board[r][c] -= cnt[r][c];
        if (board[r][c] < 0)
          board[r][c] = 0;

        if (board[r][c] > 0)
          newCoor.add(new int[] {r, c});
      }
      coor = newCoor;

      visited = new int[N][M];
      year++;

      // 빙산 덩어리 개수 -> 2개 이상이면 break / 없으면 0 출력 후 break
      int count = count();
      if (count > 1)
        break;
      else if (count == 0) {
        year = 0;
        break;
      }
    }
    System.out.println(year);
  }

  private static int count() {
    int cnt = 0, r, c;

    for (int[] pos : coor) {
      r = pos[0];
      c = pos[1];
      if (board[r][c] > 0 && visited[r][c] == 0) {
        cnt++;

        if (cnt > 1)
          return cnt;

        bfs(r, c);

      }
    }

    return cnt;

  }

  private static void bfs(int r, int c) {
    int nr, nc;
    Queue<int[]> q = new LinkedList<>();
    visited[r][c] = 1;
    q.add(new int[] {r, c});


    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      q.poll();

      for (int d = 0; d < 4; d++) {
        nr = r + drs[d];
        nc = c + dcs[d];

        if (canGo(nr, nc)) {
          visited[nr][nc] = 1;
          q.add(new int[] {nr, nc});
        }
      }
    }
  }

  private static boolean isInRange(int r, int c) {
    if (r < 0 || c < 0 || r >= N || c >= M)
      return false;
    return true;
  }

  private static boolean canGo(int r, int c) {

    if (!isInRange(r, c))
      return false;
    if (visited[r][c] == 1 || board[r][c] == 0)
      return false;

    return true;
  }
}