import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
  static int N, maxCnt, ans;
  static int[][] board;
  static ArrayList<int[]> coreList;

  static final int[] dr = {-1, 0, 1, 0};
  static final int[] dc = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());

    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine().trim());
      board = new int[N][N];
      StringTokenizer st;

      coreList = new ArrayList<>();
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());

          if (r == 0 || c == 0 || r == N - 1 || c == N - 1)
            continue;
          if (board[r][c] == 1) {
            coreList.add(new int[] {r, c});
          }
        }
      }

      ans = 0;
      maxCnt = 0;

      bt(0, 0, 0);

      System.out.println("#" + t + " " + ans);
    }
  }

  private static void bt(int idx, int cnt, int len) {
    if (cnt > maxCnt) {
      maxCnt = cnt;
      ans = len;
    } else if (cnt == maxCnt)
      ans = Math.min(ans, len);

    if (idx == coreList.size())
      return;

    for (int d = 0; d < 4; d++) {

      int wireLen = calLen(coreList.get(idx), d);

      if (wireLen < 0)
        continue;

      bt(idx + 1, cnt + 1, len + wireLen);

      rollback(coreList.get(idx), d);
    }
    bt(idx + 1, cnt, len);
  }

  private static int calLen(int[] coor, int d) {
    int r = coor[0] + dr[d], c = coor[1] + dc[d];
    while (can_go(r, c)) {
      if (board[r][c] != 0)
        return -1;

      r += dr[d];
      c += dc[d];
    }

    r = coor[0] + dr[d];
    c = coor[1] + dc[d];
    int res = 0;
    while (can_go(r, c)) {
      board[r][c] = 2;
      res++;
      r += dr[d];
      c += dc[d];
    }

    return res;
  }

  private static void rollback(int[] coor, int d) {
    int r = coor[0] + dr[d], c = coor[1] + dc[d];
    while (can_go(r, c)) {
      board[r][c] = 0;
      r += dr[d];
      c += dc[d];
    }
  }

  private static boolean can_go(int r, int c) {
    return 0 <= r && 0 <= c && r < N && c < N;

  }
}