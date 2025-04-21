import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  static int N, ans = 0;

  static int[] drs = {-1, -1, 0, 1, 1, 1, 0, -1}, dcs = {0, 1, 1, 1, 0, -1, -1, -1};

  static int[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    visited = new int[N][N];

    for (int c = 0; c < N; c++) {
      visited[0][c] = -1 * 1;
      bt(0, c, 1);
    }

    System.out.println(ans);

  }

  private static void bt(int curR, int curC, int cnt) {
    if (curR + 1 == N) {
      ans++;
      return;
    }

    // 8 방향 마킹
    int mr, mc;

    for (int d = 0; d < 8; d++) {
      mr = curR + drs[d];
      mc = curC + dcs[d];
      while (inRange(mr, mc)) {

        if (visited[mr][mc] == 0) {

          visited[mr][mc] = cnt;
        }

        mr += drs[d];
        mc += dcs[d];
      }
    }


    // 다음 놓을 위치
    int nr = curR + 1;
    for (int c = 0; c < N; c++) {
      if (visited[nr][c] == 0) {
        visited[nr][c] = -1 * (cnt + 1);
        bt(nr, c, cnt + 1);
        visited[nr][c] = 0;
      }
    }

    // 8 방향 마킹 해제
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (visited[r][c] == cnt)
          visited[r][c] = 0;
      }
    }

  }

  private static boolean inRange(int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;
    return true;
  }

}